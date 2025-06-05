package com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.create

import com.mongokafka.sandbox.consumer.ws.domain.inventory.common.InventoryExistenceAssuredUtils
import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.CreateInventoryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateInventoryUseCase(
  private val createInventoryPort: CreateInventoryPort,
  private val inventoryExistenceAssuredUtils: InventoryExistenceAssuredUtils,
) {
  @Transactional
  fun create(request: CreateInventoryRequest): Inventory {
    inventoryExistenceAssuredUtils.assureNotExists(request.sku)

    return createInventoryPort.create(request.mapToInventory())
  }
}
