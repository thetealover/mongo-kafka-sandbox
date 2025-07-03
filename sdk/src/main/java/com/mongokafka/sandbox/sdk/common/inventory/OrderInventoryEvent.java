package com.mongokafka.sandbox.sdk.common.inventory;

import lombok.Data;

@Data
public class OrderInventoryEvent {
  private String orderId;
  private InventoryStatusDto status;
}
