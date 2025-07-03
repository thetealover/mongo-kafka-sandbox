package com.mongokafka.sandbox.sdk.kafka.commons;

import static java.time.Duration.ofMinutes;
import static java.util.UUID.randomUUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Duration;
import java.util.Objects;
import java.util.StringJoiner;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class KafkaMessage implements Serializable {
  private String id = randomUUID().toString();
  private String topicName;
  private String failedConsumerGroupId;
  private int remainingRetries = 1;
  private Duration retryDelay = ofMinutes(5);

  // region getters, setters, equals, hashCode & toString
  public String getId() {
    return id;
  }

  public KafkaMessage setId(String id) {
    this.id = id;
    return this;
  }

  public String getTopicName() {
    return topicName;
  }

  public KafkaMessage setTopicName(String topicName) {
    this.topicName = topicName;
    return this;
  }

  public String getFailedConsumerGroupId() {
    return failedConsumerGroupId;
  }

  public KafkaMessage setFailedConsumerGroupId(String failedConsumerGroupId) {
    this.failedConsumerGroupId = failedConsumerGroupId;
    return this;
  }

  public int getRemainingRetries() {
    return remainingRetries;
  }

  public KafkaMessage setRemainingRetries(int remainingRetries) {
    this.remainingRetries = remainingRetries;
    return this;
  }

  public Duration getRetryDelay() {
    return retryDelay;
  }

  public KafkaMessage setRetryDelay(Duration retryDelay) {
    this.retryDelay = retryDelay;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    KafkaMessage that = (KafkaMessage) o;
    return remainingRetries == that.remainingRetries
        && Objects.equals(id, that.id)
        && Objects.equals(topicName, that.topicName)
        && Objects.equals(failedConsumerGroupId, that.failedConsumerGroupId)
        && Objects.equals(retryDelay, that.retryDelay);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, topicName, failedConsumerGroupId, remainingRetries, retryDelay);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", KafkaMessage.class.getSimpleName() + "[", "]")
        .add("id='" + id + "'")
        .add("topicName='" + topicName + "'")
        .add("failedConsumerGroupId='" + failedConsumerGroupId + "'")
        .add("remainingRetries=" + remainingRetries)
        .add("retryDelay=" + retryDelay)
        .toString();
  }
  // endregion
}
