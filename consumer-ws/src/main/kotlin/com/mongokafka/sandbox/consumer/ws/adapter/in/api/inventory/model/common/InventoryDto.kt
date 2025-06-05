package com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.common

import java.time.LocalDateTime

data class InventoryDto(
  val id: String?,
  val name: String?,
  val quantityOnHand: Int?,
  val quantityReserved: Int?,
  val reorderLevel: Int?,
  val updatedAt: LocalDateTime?,
)
