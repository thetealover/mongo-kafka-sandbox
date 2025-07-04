package com.mongokafka.sandbox.consumer.ws.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory

@EnableKafka
@Configuration
class KafkaConfiguration(val kafkaProperties: KafkaProperties) {
  private val log = LoggerFactory.getLogger(KafkaConfiguration::class.java)

  @Bean
  fun consumerFactory(): ConsumerFactory<String, String> {
    log.info("Creating Kafka Consumer Factory with properties: {}", kafkaProperties)

    return DefaultKafkaConsumerFactory(
      mapOf(
        ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers,
        ConsumerConfig.CLIENT_ID_CONFIG to kafkaProperties.clientId,
        ConsumerConfig.GROUP_ID_CONFIG to kafkaProperties.consumer.groupId,
        ConsumerConfig.AUTO_OFFSET_RESET_CONFIG to kafkaProperties.consumer.autoOffsetReset,
        ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG to kafkaProperties.consumer.enableAutoCommit,
        ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
        ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG to 30000,
        ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG to 3000,
        ConsumerConfig.MAX_POLL_RECORDS_CONFIG to 500,
      )
    )
  }

  @Bean
  fun concurrentKafkaListenerContainerFactory():
    ConcurrentKafkaListenerContainerFactory<String, String> {
    log.info("Creating ConcurrentKafkaListenerContainerFactory")

    val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
    factory.consumerFactory = consumerFactory()
    //        factory.setMissingTopicsFatal(false)
    //
    //        factory.containerProperties.apply {
    //            ackMode = ContainerProperties.AckMode.RECORD
    //            pollTimeout = 3000
    //        }

    return factory
  }
}
