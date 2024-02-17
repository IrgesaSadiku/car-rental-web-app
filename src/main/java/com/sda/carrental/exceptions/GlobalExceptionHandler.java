package com.sda.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(value = {BranchNotFoundException.class})
        @ResponseStatus(HttpStatus.NOT_FOUND)


        public ResponseEntity<String> handleOrdersNotFound(BranchNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = {CostumerNotFoundException.class})
        public ResponseEntity<String> handleUsersNotFound(CostumerNotFoundException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


