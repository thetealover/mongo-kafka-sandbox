package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.port.out.CreateOrderPort;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.event.OrderCreatedEvent;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateOrderUseCase {
  private final CreateOrderPort createOrderPort;
  private final ApplicationEventPublisher eventPublisher;

  public Order create(final CreateOrderRequest request) {
    final Order createdOrder =
        createOrderPort.create(
            Order.builder()
                .customerId(request.getCustomerId())
                .status(request.getStatus())
                .totalPrice(request.getTotalPrice())
                .currency(request.getCurrency())
                .items(request.getItems())
                .createdAt(LocalDateTime.now())
                .build());

    eventPublisher.publishEvent(new OrderCreatedEvent(createdOrder));

    return createdOrder;
  }
}
