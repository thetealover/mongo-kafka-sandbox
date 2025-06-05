package com.mongokafka.sandbox.publisher.ws.adapter.out.persitence.order;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
  Optional<Order> getOrderById(String id);
}
