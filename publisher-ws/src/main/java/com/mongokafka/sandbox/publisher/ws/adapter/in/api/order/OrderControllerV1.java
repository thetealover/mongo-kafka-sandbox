package com.mongokafka.sandbox.publisher.ws.adapter.in.api.order;

import static java.util.Optional.ofNullable;
import static org.springframework.http.HttpStatus.CREATED;

import com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.common.OrderDto;
import com.mongokafka.sandbox.publisher.ws.adapter.in.api.order.dto.create.CreateOrderRequestDto;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.Order;
import com.mongokafka.sandbox.publisher.ws.domain.order.model.OrderStatus;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.CreateOrderRequest;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.CreateOrderUseCase;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.get.GetOrderByIdUseCase;
import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.list.ListOrdersUseCase;
import com.naharoo.commons.mapstruct.MappingFacade;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/orders")
@Tag(name = "Orders Controller V1")
public class OrderControllerV1 {
  private final MappingFacade mappingFacade;
  private final ListOrdersUseCase listOrdersUseCase;
  private final CreateOrderUseCase createOrderUseCase;
  private final GetOrderByIdUseCase getOrderByIdUseCase;

  @PostMapping
  @ResponseStatus(CREATED)
  public OrderDto create(@RequestBody @NotNull final CreateOrderRequestDto requestDto) {
    log.debug("Creating Order for request: {}", requestDto);

    final CreateOrderRequest request = mappingFacade.map(requestDto, CreateOrderRequest.class);
    final Order order = createOrderUseCase.create(request);
    final OrderDto response = mappingFacade.map(order, OrderDto.class);

    log.info("Created Order: {}", response);
    return response;
  }

  @GetMapping("/{id}")
  public OrderDto getOrderById(@PathVariable("id") final String id) {
    log.debug("Getting Order by id: {}", id);

    final Order order = getOrderByIdUseCase.getById(id);
    final OrderDto response = mappingFacade.map(order, OrderDto.class);

    log.info("Got Order: {}", response);
    return response;
  }

  @GetMapping("/list")
  public List<OrderDto> listOrders(
      @RequestParam(value = "customerId", required = false) @NotBlank final String customerId,
      @RequestParam(value = "status", required = false) final OrderStatus status,
      @RequestParam(value = "from", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy")
          final LocalDate from,
      @RequestParam(value = "to", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy")
          final LocalDate to) {
    log.debug("Listing Orders for customerId: {}, status: {}", customerId, status);

    final LocalDateTime localDateTimeFrom =
        ofNullable(from).map(LocalDate::atStartOfDay).orElse(null);
    final LocalDateTime localDateTimeTo = ofNullable(to).map(LocalDate::atStartOfDay).orElse(null);

    final List<Order> orders =
        listOrdersUseCase.list(customerId, status, localDateTimeFrom, localDateTimeTo);
    final List<OrderDto> response = mappingFacade.mapAsList(orders, OrderDto.class);

    log.info("Listed Orders. Total elements fetched: {}", response.size());
    return response;
  }
}
