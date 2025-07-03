package com.mongokafka.sandbox.publisher.ws.adapter.out.kafka.producer;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderItem;
import com.mongokafka.sandbox.sdk.common.order.OrderItemDto;
import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import org.mapstruct.Mapper;

@Mapper
public interface OrderItemEventDtoMapper extends UnidirectionalMapper<OrderItem, OrderItemDto> {
  @Override
  OrderItemDto map(OrderItem orderItem);
}
