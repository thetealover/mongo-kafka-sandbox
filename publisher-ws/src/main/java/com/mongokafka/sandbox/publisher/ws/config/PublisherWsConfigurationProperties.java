package com.mongokafka.sandbox.publisher.ws.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "ws")
public class PublisherWsConfigurationProperties {
  private String version;
}
