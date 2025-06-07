package com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.restock

import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.restock.RestockInventoryRequest
import jakarta.validation.constraints.NotNull

data class RestockInventoryRequestDto(@field:NotNull val amount: Int?) {
  fun mapToRestockInventoryRequest(sku: String) =
    RestockInventoryRequest(amount = amount!!, sku = sku)
}
