package com.mongokafka.sandbox.consumer.ws

import com.mongokafka.sandbox.consumer.ws.config.ConsumerWsConfigurationProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(value = [ConsumerWsConfigurationProperties::class])
class ConsumerWs {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      runApplication<ConsumerWs>(*args)
    }
  }
}
