package com.mongokafka.sandbox.publisher.ws.adapter.out.persitence.order;

import static java.util.Objects.nonNull;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import com.mongokafka.sandbox.publisher.ws.domain.order.port.out.CreateOrderPort;
import com.mongokafka.sandbox.publisher.ws.domain.order.port.out.QueryOrderPort;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements CreateOrderPort, QueryOrderPort {
  private final OrderRepository repository;
  private final MongoTemplate mongoTemplate;

  @Override
  public Order create(final Order order) {
    return repository.insert(order);
  }

  @Override
  public Optional<Order> findById(final String id) {
    return repository.getOrderById(id);
  }

  @Override
  public List<Order> list(
      final String customerId,
      final OrderStatus status,
      final LocalDateTime from,
      final LocalDateTime to) {
    final Criteria criteria = Criteria.where("customerId").is(customerId);

    Optional.ofNullable(status).ifPresent(orderStatus -> criteria.and("status").is(orderStatus));
    if (nonNull(from) && nonNull(to)) {
      criteria.and("createdAt").gte(from).lte(to);
    } else if (nonNull(from)) {
      criteria.and("createdAt").gte(from);
    } else if (nonNull(to)) {
      criteria.and("createdAt").lte(to);
    }

    return mongoTemplate.find(Query.query(criteria), Order.class);
  }
}
