package com.mongokafka.sandbox.sdk.common.order;

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

public class OrderCreatedEventDto extends KafkaMessage {
  private String orderId;
  private String customerId;
  private String currency;
  private List<OrderItemDto> items;

  public OrderCreatedEventDto(
      String orderId, String customerId, String currency, List<OrderItemDto> items) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.currency = currency;
    this.items = items;
  }

  // region Getters, Setters, equals, hashCode, toString
  public String getOrderId() {
    return orderId;
  }

  public OrderCreatedEventDto setOrderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

  public String getCustomerId() {
    return customerId;
  }

  public OrderCreatedEventDto setCustomerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

  public String getCurrency() {
    return currency;
  }

  public OrderCreatedEventDto setCurrency(String currency) {
    this.currency = currency;
    return this;
  }

  public List<OrderItemDto> getItems() {
    return items;
  }

  public OrderCreatedEventDto setItems(List<OrderItemDto> items) {
    this.items = items;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    OrderCreatedEventDto that = (OrderCreatedEventDto) o;
    return Objects.equals(orderId, that.orderId)
        && Objects.equals(customerId, that.customerId)
        && Objects.equals(currency, that.currency)
        && Objects.equals(items, that.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, customerId, currency, items);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", OrderCreatedEventDto.class.getSimpleName() + "[", "]")
        .add("orderId='" + orderId + "'")
        .add("customerId='" + customerId + "'")
        .add("currency='" + currency + "'")
        .add("items=" + items)
        .toString();
  }
  // endregion
}
