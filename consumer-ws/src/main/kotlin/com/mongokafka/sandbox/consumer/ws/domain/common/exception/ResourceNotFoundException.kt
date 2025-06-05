package com.mongokafka.sandbox.consumer.ws.domain.common.exception

import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = NOT_FOUND, reason = "Resource not found")
class ResourceNotFoundException(message: String? = "Resource not found") :
  RuntimeException(message)
