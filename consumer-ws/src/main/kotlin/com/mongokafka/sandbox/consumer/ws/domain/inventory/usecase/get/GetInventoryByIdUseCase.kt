package com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.get

import com.mongokafka.sandbox.consumer.ws.domain.inventory.common.InventoryExistenceAssuredUtils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetInventoryByIdUseCase(
  private val inventoryExistenceAssuredUtils: InventoryExistenceAssuredUtils
) {
  @Transactional(readOnly = true)
  fun getById(id: String) = inventoryExistenceAssuredUtils.fetchExistenceAssured(id)
}
