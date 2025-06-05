package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common.OrderItemDto;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import java.math.BigDecimal;
import java.util.List;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateOrderRequestDto {
  private String customerId;
  private OrderStatus status;
  private BigDecimal totalPrice;
  private String currency;
  private List<OrderItemDto> items;
}
