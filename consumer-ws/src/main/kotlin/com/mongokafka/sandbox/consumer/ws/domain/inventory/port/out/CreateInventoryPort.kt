package com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out

import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory

interface CreateInventoryPort {
  fun create(inventory: Inventory): Inventory
}
