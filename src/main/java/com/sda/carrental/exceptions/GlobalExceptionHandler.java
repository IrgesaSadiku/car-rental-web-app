package com.sda.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
    public class GlobalExceptionHandler {
    @ExceptionHandler(value = {BranchNotFoundException.class})
        public ResponseEntity<String> handleBranchNotFound(BranchNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    @ExceptionHandler(value = {CostumerNotFoundException.class})
    public ResponseEntity<String> handleCostumerNotFound(CostumerNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    }


