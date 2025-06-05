package com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.create

import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.create.CreateInventoryRequest
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateInventoryRequestDto(
  @NotBlank val sku: String?,
  @NotBlank val name: String?,
  @NotNull val quantityOnHand: Int?,
  @NotNull val reorderLevel: Int?,
) {
  fun mapToCreateInventoryRequest() =
    CreateInventoryRequest(
      sku = sku!!,
      name = name!!,
      quantityOnHand = quantityOnHand!!,
      reorderLevel = reorderLevel!!,
    )
}
