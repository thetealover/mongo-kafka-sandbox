package com.mongokafka.sandbox.publisher.ws.config;

import static org.apache.kafka.clients.producer.ProducerConfig.*;
import static org.apache.kafka.clients.producer.ProducerConfig.COMPRESSION_TYPE_CONFIG;

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Slf4j
@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfiguration {

  private final KafkaProperties kafkaProperties;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    log.info(
        "Initializing Kafka Admin with bootstrap servers: {}",
        kafkaProperties.getBootstrapServers());
    return new KafkaAdmin(Map.of(BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers()));
  }

  @Bean
  public ProducerFactory<String, KafkaMessage> kafkaProducerFactory() {
    log.info(
        "Initializing Kafka Producer Factory with bootstrap servers: {}",
        kafkaProperties.getBootstrapServers());

    return new DefaultKafkaProducerFactory<>(
        Map.of(
            BOOTSTRAP_SERVERS_CONFIG,
            kafkaProperties.getBootstrapServers(),
            KEY_SERIALIZER_CLASS_CONFIG,
            StringSerializer.class,
            VALUE_SERIALIZER_CLASS_CONFIG,
            JsonSerializer.class,
            COMPRESSION_TYPE_CONFIG,
            "snappy"));
  }

  @Bean
  public KafkaTemplate<String, KafkaMessage> kafkaTemplate() {
    log.info("Initializing Kafka Template");

    return new KafkaTemplate<>(kafkaProducerFactory());
  }
}
