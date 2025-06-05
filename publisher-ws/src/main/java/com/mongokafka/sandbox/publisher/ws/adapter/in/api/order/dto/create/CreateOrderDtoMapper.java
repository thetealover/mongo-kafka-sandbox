package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.create;

import com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common.OrderItemDtoMapper;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.CreateOrderRequest;
import com.naharoo.commons.mapstruct.UnidirectionalMapper;
import org.mapstruct.Mapper;

@Mapper(uses = OrderItemDtoMapper.class)
public interface CreateOrderDtoMapper
    extends UnidirectionalMapper<CreateOrderRequestDto, CreateOrderRequest> {}
