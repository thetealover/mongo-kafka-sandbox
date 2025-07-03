package com.mongokafka.sandbox.sdk.common.order;

import lombok.Data;

@Data
public class OrderItemDto {
  private String sku;
  private Integer quantity;
}
