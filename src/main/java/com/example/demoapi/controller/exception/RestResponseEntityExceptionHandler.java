package com.example.demoapi.controller.exception;

import com.example.demoapi.service.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ApiError> objectNotFound(ObjectNotFoundException obj, HttpServletRequest request) {
        final HttpStatus status = HttpStatus.NOT_FOUND;
        final ApiError apiError = ApiError.builder()
                .timestamp(System.currentTimeMillis())
                .status(status.value())
                .error("Não encontrado.")
                .message(obj.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(status).body(apiError);

    }
}
