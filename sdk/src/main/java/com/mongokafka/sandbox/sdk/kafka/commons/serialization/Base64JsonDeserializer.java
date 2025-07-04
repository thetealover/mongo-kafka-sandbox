package com.mongokafka.sandbox.sdk.kafka.commons.serialization;

import static java.util.Objects.nonNull;

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import java.util.Base64;
import org.apache.kafka.common.header.Headers;
import org.springframework.kafka.support.serializer.JsonDeserializer;

public class Base64JsonDeserializer extends JsonDeserializer<KafkaMessage> {

  @Override
  public KafkaMessage deserialize(String topic, Headers headers, byte[] data) {
    if (nonNull(data)) {
      data = Base64.getDecoder().decode(data);
    }
    return super.deserialize(topic, headers, data);
  }

  @Override
  public KafkaMessage deserialize(String topic, byte[] data) {
    if (nonNull(data)) {
      data = Base64.getDecoder().decode(data);
    }
    return super.deserialize(topic, data);
  }
}
