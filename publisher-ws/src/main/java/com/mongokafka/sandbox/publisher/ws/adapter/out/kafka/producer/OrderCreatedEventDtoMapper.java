package com.mongokafka.sandbox.publisher.ws.adapter.out.kafka.producer;

import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.event.OrderCreatedEvent;
import com.mongokafka.sandbox.sdk.common.order.OrderCreatedEventDto;
import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderCreatedEventDtoMapper
    extends UnidirectionalMapper<OrderCreatedEvent, OrderCreatedEventDto> {

  @Mapping(target = "orderId", source = "order.id")
  @Mapping(target = "items", ignore = true)
  @Mapping(target = "currency", source = "order.currency")
  @Mapping(target = "customerId", source = "order.customerId")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "topicName", ignore = true)
  @Mapping(target = "retryDelay", ignore = true)
  @Mapping(target = "remainingRetries", ignore = true)
  @Mapping(target = "failedConsumerGroupId", ignore = true)
  @Override
  OrderCreatedEventDto map(OrderCreatedEvent event);
}
