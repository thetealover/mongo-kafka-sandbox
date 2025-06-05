package com.mongokafka.sandbox.consumer.ws.domain.inventory.common

import com.mongokafka.sandbox.consumer.ws.domain.common.exception.ResourceAlreadyExistsException
import com.mongokafka.sandbox.consumer.ws.domain.common.exception.ResourceNotFoundException
import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.QueryInventoryPort
import org.springframework.stereotype.Repository

@Repository
class InventoryExistenceAssuredUtils(private val queryInventoryPort: QueryInventoryPort) {
  fun assureNotExists(sku: String) =
    queryInventoryPort.findById(sku)?.let {
      throw ResourceAlreadyExistsException("Inventory already exists with id=$sku")
    }

  fun fetchExistenceAssured(sku: String): Inventory =
    queryInventoryPort.findById(sku)
      ?: throw ResourceNotFoundException("Inventory does not exist with id=$sku")
}
