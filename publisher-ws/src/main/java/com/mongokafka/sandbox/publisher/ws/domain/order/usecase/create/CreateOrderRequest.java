package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderItem;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {
  private String customerId;
  private OrderStatus status;
  private BigDecimal totalPrice;
  private String currency;
  private List<OrderItem> items;
}
