package com.mongokafka.sandbox.publisher.ws;

import com.mongokafka.sandbox.publisher.ws.config.PublisherWsConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({PublisherWsConfigurationProperties.class})
public class PublisherWs {
  public static void main(String[] args) {
    SpringApplication.run(PublisherWs.class, args);
  }
}
