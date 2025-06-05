package com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.restock

data class RestockInventoryRequest(val sku: String, val amount: Int)
