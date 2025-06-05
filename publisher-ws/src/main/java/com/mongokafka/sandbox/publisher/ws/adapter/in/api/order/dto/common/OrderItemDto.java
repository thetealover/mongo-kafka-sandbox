package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderItemDto {
  private String sku;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal lineTotal;
}
