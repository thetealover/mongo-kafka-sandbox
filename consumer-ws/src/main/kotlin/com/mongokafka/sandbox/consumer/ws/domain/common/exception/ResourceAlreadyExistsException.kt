package com.mongokafka.sandbox.consumer.ws.domain.common.exception

import org.springframework.http.HttpStatus.CONFLICT
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = CONFLICT, reason = "Resource already exists")
class ResourceAlreadyExistsException(message: String? = "Resource already exists") :
  RuntimeException(message) {}
