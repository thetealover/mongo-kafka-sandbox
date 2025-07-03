package com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory

import com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.common.InventoryDto
import com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.create.CreateInventoryRequestDto
import com.mongokafka.sandbox.consumer.ws.adapter.`in`.api.inventory.model.restock.RestockInventoryRequestDto
import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.create.CreateInventoryUseCase
import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.get.GetInventoryByIdUseCase
import com.mongokafka.sandbox.consumer.ws.domain.inventory.usecase.restock.RestockInventoryUseCase
import io.github.oshai.kotlinlogging.KotlinLogging
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus.CREATED
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Validated
@RestController
@RequestMapping("/v1/inventories")
@Tag(name = "Inventories Controller V1")
class InventoryControllerV1(
  private val createInventoryUseCase: CreateInventoryUseCase,
  private val restockInventoryUseCase: RestockInventoryUseCase,
  private val getInventoryByIdUseCase: GetInventoryByIdUseCase,
) {
  private val log = KotlinLogging.logger {}

  @PostMapping
  @ResponseStatus(CREATED)
  fun create(@RequestBody @Valid requestDto: CreateInventoryRequestDto): InventoryDto {
    log.debug { "Creating Inventory for request: $requestDto" }

    val inventory = createInventoryUseCase.create(requestDto.mapToCreateInventoryRequest())
    val response = inventory.mapToDto()

    log.info { "Created Inventory. response: $response" }
    return response
  }

  @PatchMapping("/{sku}/restock")
  fun restock(
    @PathVariable("sku") sku: String,
    @RequestBody @Valid requestDto: RestockInventoryRequestDto,
  ): InventoryDto {
    log.debug { "Restocking Inventory for request: $requestDto" }

    val inventory = restockInventoryUseCase.restock(requestDto.mapToRestockInventoryRequest(sku))
    val response = inventory.mapToDto()

    log.info { "Restocked Inventory. response: $requestDto" }
    return response
  }

  @GetMapping("/{id}")
  fun getById(@PathVariable("id") id: String): InventoryDto {
    log.debug { "Getting Inventory with id: $id" }

    val inventory = getInventoryByIdUseCase.getById(id)
    val response = inventory.mapToDto()

    log.info { "Got Inventory by id: $id. response: $response" }
    return response
  }
}
