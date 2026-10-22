# mongo-kafka-sandbox

Two Spring Boot 3 services exchanging domain events over Apache Kafka, with MongoDB persistence and a hexagonal (ports and adapters) layout.

| Module | Language | Role |
|---|---|---|
| `publisher-ws` | Java 21 | Orders API (`/v1/orders`). Persists orders to MongoDB and publishes an `OrderCreated` event to Kafka |
| `consumer-ws` | Kotlin | Inventory API (`/v1/inventories`: create, restock, get). Listens on `order-created-topic` |
| `sdk` | Java | Shared event contracts (`OrderCreatedEventDto`, `KafkaMessage`) and topic names |

## How it flows

1. `POST /v1/orders` calls `CreateOrderUseCase`, which saves the order through an outbound port backed by a MongoDB adapter
2. The use case raises a Spring application event; `OrderCreatedKafkaMessageProducer` maps it to the shared SDK contract and sends it with `KafkaTemplate`
3. `consumer-ws` receives it through a `@KafkaListener` on `order-created-topic`

## Stack

Java 21 · Kotlin 2.1 · Spring Boot 3.5 · Spring Kafka 3.3 · Spring Data MongoDB · MapStruct · springdoc-openapi · Gradle version catalog · Spotless (google-java-format, ktfmt) · Docker Compose

## Run locally

```bash
# Kafka on localhost:29092, MongoDB on localhost:27017
docker compose up -d

# Orders API on http://localhost:8080
./gradlew :publisher-ws:bootRun --args='--spring.profiles.active=local'

# Inventory API on http://localhost:8081
./gradlew :consumer-ws:bootRun --args='--spring.profiles.active=local'
```

Each service serves Swagger UI at `/swagger-ui.html`.
