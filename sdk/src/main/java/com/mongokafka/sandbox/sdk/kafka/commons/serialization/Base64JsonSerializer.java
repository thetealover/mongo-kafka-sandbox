package com.mongokafka.sandbox.sdk.kafka.commons.serialization;

import com.mongokafka.sandbox.sdk.kafka.commons.KafkaMessage;
import java.util.Base64;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class Base64JsonSerializer extends JsonSerializer<KafkaMessage> {

  @Override
  public byte[] serialize(String topic, KafkaMessage data) {
    final byte[] bytes = super.serialize(topic, data);

    if (bytes == null) {
      return null;
    }

    return Base64.getEncoder().encode(bytes);
  }
}
