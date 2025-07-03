package com.mongokafka.sandbox.sdk.common.order;

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderCreatedEventDto extends KafkaMessage {
  private String orderId;
  private String customerId;
  private String currency;
  private List<OrderItemDto> items;
}
