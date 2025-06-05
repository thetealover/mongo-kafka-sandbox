package com.mongokafka.sandbox.publisher.ws.domain.order.port.out;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface QueryOrderPort {
  Optional<Order> findById(String id);

  List<Order> list(String customerId, OrderStatus status, LocalDateTime from, LocalDateTime to);
}
