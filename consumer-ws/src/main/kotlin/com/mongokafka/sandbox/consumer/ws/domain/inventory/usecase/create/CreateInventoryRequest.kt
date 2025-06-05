package com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.create

import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory

data class CreateInventoryRequest(
  val sku: String,
  val name: String,
  val quantityOnHand: Int,
  val reorderLevel: Int,
) {
  fun mapToInventory(): Inventory =
    Inventory(
      id = sku,
      name = name,
      quantityOnHand = quantityOnHand,
      quantityReserved = null,
      reorderLevel = reorderLevel,
      updatedAt = null,
    )
}
