package com.exchange.exchangeservice.exception;

import java.time.LocalDate;
import com.exchange.exchangeservice.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CurrencyNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundExceptions(CurrencyNotFoundException exception, WebRequest request) {
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(LocalDate.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
