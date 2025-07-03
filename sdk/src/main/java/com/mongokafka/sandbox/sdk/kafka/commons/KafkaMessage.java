package com.mongokafka.sandbox.sdk.kafka.commons;

import static java.time.Duration.ofMinutes;
import static java.util.UUID.randomUUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Duration;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class KafkaMessage implements Serializable {
  private String id = randomUUID().toString();
  private String topicName;
  private String failedConsumerGroupId;
  private int remainingRetries = 1;
  private Duration retryDelay = ofMinutes(5);
}
