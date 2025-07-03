package com.mongokafka.sandbox.sdk.common.inventory;

import java.util.Objects;
import java.util.StringJoiner;

public class OrderInventoryEvent {
  private String orderId;
  private InventoryStatusDto status;

  public OrderInventoryEvent(String orderId, InventoryStatusDto status) {
    this.orderId = orderId;
    this.status = status;
  }

  // region Getters, Setters, equals, hashCode, toString
  public String getOrderId() {
    return orderId;
  }

  public OrderInventoryEvent setOrderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public InventoryStatusDto getStatus() {
    return status;
  }

  public OrderInventoryEvent setStatus(InventoryStatusDto status) {
    this.status = status;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    OrderInventoryEvent that = (OrderInventoryEvent) o;
    return Objects.equals(orderId, that.orderId) && status == that.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, status);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OrderInventoryEvent.class.getSimpleName() + "[", "]")
        .add("orderId='" + orderId + "'")
        .add("status=" + status)
        .toString();
  }
  // endregion
}
