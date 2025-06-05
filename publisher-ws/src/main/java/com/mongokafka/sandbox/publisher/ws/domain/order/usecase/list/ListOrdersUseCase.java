package com.mongokafka.sandbox.publisher.ws.domain.order.usecase.list;

import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import com.mongokafka.sandbox.publisher.ws.domain.order.port.out.QueryOrderPort;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListOrdersUseCase {
  private final QueryOrderPort queryOrderPort;

  public List<Order> list(
      final String customerId,
      final OrderStatus status,
      final LocalDateTime from,
      final LocalDateTime to) {
    return queryOrderPort.list(customerId, status, from, to);
  }
}
