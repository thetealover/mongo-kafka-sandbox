package com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.restock

import com.mongokafka.sandbox.consumer.ws.domain.inventory.common.InventoryExistenceAssuredUtils
import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.UpdateInventoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RestockInventoryUseCase(
  private val updateInventoryPort: UpdateInventoryPort,
  private val inventoryExistenceAssuredUtils: InventoryExistenceAssuredUtils,
) {

  @Transactional
  fun restock(request: RestockInventoryRequest): Inventory {
    val inventory = inventoryExistenceAssuredUtils.fetchExistenceAssured(request.sku)

    inventory.quantityOnHand = inventory.quantityOnHand!! + request.amount
    return updateInventoryPort.update(inventory)
  }
}
