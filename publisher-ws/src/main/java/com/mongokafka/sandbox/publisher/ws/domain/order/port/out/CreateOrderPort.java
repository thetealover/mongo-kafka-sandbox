package com.mongokafka.sandbox.publisher.ws.domain.order.port.out;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;

public interface CreateOrderPort {
  Order create(Order order);
}
