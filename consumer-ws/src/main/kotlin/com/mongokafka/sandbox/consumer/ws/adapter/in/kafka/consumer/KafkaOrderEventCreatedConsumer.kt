package com.mongokafka.sandbox.consumer.ws.adapter.`in`.kafka.consumer

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaTopicName.ORDER_CREATED_TOPIC
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaOrderEventCreatedConsumer {
  private val log: Logger = LoggerFactory.getLogger(KafkaOrderEventCreatedConsumer::class.java)

  @KafkaListener(topics = [ORDER_CREATED_TOPIC])
  fun consume(event: String) {
    log.info("Received event $event")
  }
}
