package com.mongokafka.sandbox.publisher.ws.domain.order.model;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
@CompoundIndexes({
  @CompoundIndex(name = "customer_date_index", def = "{ 'customerId': 1, 'createdAt': -1 }")
})
public class Order {
  @Id private String id;

  @Field(name = "customerId")
  private String customerId;

  @Field(name = "status")
  private OrderStatus status;

  @Field(name = "totalPrice", targetType = DECIMAL128)
  private BigDecimal totalPrice;

  @Field(name = "currency")
  private String currency;

  @Field(name = "items")
  private List<OrderItem> items;

  @CreatedDate
  @Field(name = "createdAt")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Field(name = "updatedAt")
  private LocalDateTime updatedAt;

  @Version
  @Field(name = "version")
  private Long version;
}
