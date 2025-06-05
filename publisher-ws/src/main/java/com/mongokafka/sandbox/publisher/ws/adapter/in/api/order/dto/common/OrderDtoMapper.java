package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import org.mapstruct.Mapper;

@Mapper(uses = OrderItemDtoMapper.class)
public interface OrderDtoMapper extends UnidirectionalMapper<Order, OrderDto> {}
