package com.mongokafka.sandbox.consumer.ws.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiSwaggerConfiguration(private val properties: ConsumerWsConfigurationProperties) {

  @Bean
  fun openApiDefinition(): OpenAPI =
    OpenAPI()
      .servers(listOf(Server().url("/")))
      .info(
        Info()
          .title("Mongo-Kafka Sandbox Consumer WS")
          .contact(Contact().url("https://t.me/hell_b0"))
          .version(properties.version)
      )
}
