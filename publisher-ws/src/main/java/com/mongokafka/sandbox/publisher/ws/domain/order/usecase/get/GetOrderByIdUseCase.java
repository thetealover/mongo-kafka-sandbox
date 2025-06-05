package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.get;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.port.out.QueryOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetOrderByIdUseCase {
  private final QueryOrderPort queryOrderPort;

  public Order getById(final String id) {
    return queryOrderPort.findById(id).orElseThrow();
  }
}
