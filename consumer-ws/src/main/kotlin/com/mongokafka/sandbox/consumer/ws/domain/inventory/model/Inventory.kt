package com.mongokafka.sandbox.consumer.ws.domain.inventory.model

import com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.common.InventoryDto
import java.time.LocalDateTime
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = "inventories")
class Inventory(
  @Id val id: String?,
  @Field(name = "name") var name: String?,
  @Field(name = "quantityOnHand") var quantityOnHand: Int?,
  @Field(name = "quantityReserved") var quantityReserved: Int?,
  @Field(name = "reorderLevel") var reorderLevel: Int?,
  @LastModifiedDate @Field(name = "updatedAt") var updatedAt: LocalDateTime?,
) {
  fun mapToDto() =
    InventoryDto(
      id = id,
      name = name,
      quantityOnHand = quantityOnHand,
      quantityReserved = quantityReserved,
      reorderLevel = reorderLevel,
      updatedAt = updatedAt,
    )
}
