package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.event;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderCreatedEvent {
  private final Order order;
}
