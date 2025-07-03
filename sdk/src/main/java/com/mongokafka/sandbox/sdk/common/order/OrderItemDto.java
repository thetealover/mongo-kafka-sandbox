package com.mongokafka.sandbox.sdk.common.order;

import java.util.Objects;
import java.util.StringJoiner;

public class OrderItemDto {
  private String sku;
  private Integer quantity;

  public OrderItemDto(String sku, Integer quantity) {
    this.sku = sku;
    this.quantity = quantity;
  }

  // region Getters, Setters, equals, hashCode, toString
  public String getSku() {
    return sku;
  }

  public OrderItemDto setSku(String sku) {
    this.sku = sku;
    return this;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public OrderItemDto setQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    OrderItemDto itemDto = (OrderItemDto) o;
    return Objects.equals(sku, itemDto.sku) && Objects.equals(quantity, itemDto.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, quantity);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OrderItemDto.class.getSimpleName() + "[", "]")
        .add("sku='" + sku + "'")
        .add("quantity=" + quantity)
        .toString();
  }
  // endregion
}
