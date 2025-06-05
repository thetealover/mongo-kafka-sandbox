package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderItem;
import com.naharoo.commons.mapstruct.BidirectionalMapper;
import org.mapstruct.Mapper;

@Mapper
public interface OrderItemDtoMapper extends BidirectionalMapper<OrderItemDto, OrderItem> {
  @Override
  OrderItem map(OrderItemDto orderItemDto);

  @Override
  OrderItemDto mapReverse(OrderItem orderItem);
}
