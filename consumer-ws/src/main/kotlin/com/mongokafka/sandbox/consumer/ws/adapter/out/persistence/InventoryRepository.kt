package com.mongokafka.sandbox.consumer.ws.adapter.out.persistence

import com.mongokafka.sandbox.consumer.ws.domain.inventory.model.Inventory
import org.springframework.data.mongodb.repository.MongoRepository

interface InventoryRepository : MongoRepository<Inventory, String>
