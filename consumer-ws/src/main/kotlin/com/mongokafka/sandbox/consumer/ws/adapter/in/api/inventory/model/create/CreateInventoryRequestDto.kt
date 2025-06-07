package com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.create

import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.create.CreateInventoryRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateInventoryRequestDto(
  @field:NotBlank val sku: String?,
  @field:NotBlank val name: String?,
  @field:NotNull val quantityOnHand: Int?,
  @field:NotNull val reorderLevel: Int?,
) {
  fun mapToCreateInventoryRequest() =
    CreateInventoryRequest(
      sku = sku!!,
      name = name!!,
      quantityOnHand = quantityOnHand!!,
      reorderLevel = reorderLevel!!,
    )
}
