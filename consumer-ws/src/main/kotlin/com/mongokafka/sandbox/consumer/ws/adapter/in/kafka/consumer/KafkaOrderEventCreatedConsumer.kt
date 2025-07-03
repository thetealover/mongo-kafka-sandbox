package com.mongokafka.sandbox.consumer.ws.adapter.`in`.kafka.consumer

import com.mongokafka.sandbox.sdk.common.order.OrderCreatedEventDto
import com.mongokafka.sandbox.sdk.kafka.commons.KafkaTopicName.ORDER_CREATED_TOPIC
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class KafkaOrderEventCreatedConsumer {
  private val log = KotlinLogging.logger {}

  @KafkaListener(
    topics = [ORDER_CREATED_TOPIC],
    containerFactory = "concurrentKafkaListenerContainerFactory",
  )
  fun consume(@Payload event: OrderCreatedEventDto) {
    log.info { "Received event $event" }
  }
}
