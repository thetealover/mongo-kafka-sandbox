package com.mongokafka.sandbox.publisher.ws.domain.order.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
  private String sku;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal lineTotal;
}
