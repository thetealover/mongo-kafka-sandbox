package com.mongokafka.sandbox.publisher.ws.adapter.out.kafka.producer;

import static com.mongokafka.sandbox.sdk.kafka.commons.KafkaTopicName.ORDER_CREATED_TOPIC;
import static java.util.Optional.ofNullable;

import com.mongokafka.sandbox.publisher.ws.domain.order.usecase.create.event.OrderCreatedEvent;
import com.mongokafka.sandbox.sdk.common.order.OrderCreatedEventDto;
import com.mongokafka.sandbox.sdk.common.order.OrderItemDto;
import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import com.naharoo.commons.mapstruct.MappingFacade;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreatedKafkaMessageProducer {
  private final MappingFacade mappingFacade;
  private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

  @SneakyThrows
  @EventListener(OrderCreatedEvent.class)
  public void consume(final OrderCreatedEvent event) {
    final List<OrderItemDto> orderItemDtos =
        mappingFacade.mapAsList(event.getOrder().getItems(), OrderItemDto.class);
    final OrderCreatedEventDto eventDto = mappingFacade.map(event, OrderCreatedEventDto.class);
    eventDto.setItems(orderItemDtos);
    eventDto.setTopicName(ORDER_CREATED_TOPIC);

    final CompletableFuture<SendResult<String, KafkaMessage>> completableFuture =
        kafkaTemplate.send(ORDER_CREATED_TOPIC, eventDto);
    completableFuture.whenComplete(
        (result, ex) ->
            ofNullable(ex)
                .ifPresentOrElse(
                    throwable ->
                        log.error(
                            "Failed to publish event to Kafka topic: {} with payload: {}",
                            ORDER_CREATED_TOPIC,
                            eventDto,
                            ex),
                    () ->
                        log.info(
                            "Successfully published event to Kafka topic: {} with payload: {}",
                            ORDER_CREATED_TOPIC,
                            eventDto)));
  }
}
