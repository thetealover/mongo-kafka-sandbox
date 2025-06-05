package com.mongokafka.sandbox.consumer.ws.adapter.out.persistence

import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.CreateInventoryPort
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.QueryInventoryPort
import com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out.UpdateInventoryPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class InventoryPersistenceAdapter(private var repository: InventoryRepository) :
  CreateInventoryPort, UpdateInventoryPort, QueryInventoryPort {

  override fun create(inventory: Inventory): Inventory = repository.insert(inventory)

  override fun update(inventory: Inventory): Inventory = repository.save(inventory)

  override fun findById(id: String): Inventory? = repository.findByIdOrNull(id)
}
