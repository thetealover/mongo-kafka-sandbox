package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
  private String id;
  private String customerId;
  private OrderStatus status;
  private BigDecimal totalPrice;
  private String currency;
  private List<OrderItemDto> items;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
