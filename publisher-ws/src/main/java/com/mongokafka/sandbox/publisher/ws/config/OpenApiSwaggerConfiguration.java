package com.mongokafka.sandbox.publisher.ws.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class OpenApiSwaggerConfiguration {

  private final PublisherWsConfigurationProperties properties;

  @Bean
  public OpenAPI openApiDefinition() {
    return new OpenAPI()
        .servers(List.of(new Server().url("/")))
        .info(
            new Info()
                .title("Mongo-Kafka Sandbox Publisher WS")
                .contact(new Contact().url("https://t.me/hell_b0"))
                .version(properties.getVersion()));
  }
}
