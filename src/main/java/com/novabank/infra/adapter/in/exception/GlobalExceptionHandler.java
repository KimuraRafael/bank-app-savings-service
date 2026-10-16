package com.novabank.infra.adapter.in.exception;

import com.novabank.infra.adapter.in.dto.ErrorResponse;
import com.novabank.savings.domain.exception.SavingsNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SavingsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(SavingsNotFoundException ex) {
        ErrorResponse body = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleInvalid(IllegalArgumentException ex) {

        ErrorResponse body = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);

    }
}