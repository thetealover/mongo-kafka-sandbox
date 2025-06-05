package com.mongokafka.sandbox.consumer.ws.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "ws")
class ConsumerWsConfigurationProperties {
  lateinit var version: String
}
