package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.event;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class OrderCreatedEvent {
  private final Order order;
}
