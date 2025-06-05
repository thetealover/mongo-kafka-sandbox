package com.mongokafka.sandbox.consumer.ws.domain.inventory.port.out

import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory

interface UpdateInventoryPort {
  fun update(inventory: Inventory): Inventory
}
