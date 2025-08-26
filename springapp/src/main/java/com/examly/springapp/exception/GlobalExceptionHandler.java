package com.examly.springapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException ex) {
Map<String, Object> response = new HashMap<>();
response.put("message", "Validation failed");

List<String> errors = ex.getBindingResult()
.getFieldErrors()
.stream()
.map(err -> err.getField() + ": " + err.getDefaultMessage())
.collect(Collectors.toList());

response.put("errors", errors);
return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
}
}

