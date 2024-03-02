package com.sda.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

    @ExceptionHandler(value = {CarNotFoundException.class})
    public ResponseEntity<String> handleCarNotFound(CarNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RentalNotFoundException.class})
    public ResponseEntity<String> handleRentalNotFound(RentalNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {ReservationNotFoundException.class})
    public ResponseEntity<String> handleReservationNotFound(ReservationNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {RevenueNotFoundException.class})
    public ResponseEntity<String> handleRevenueNotFound(RevenueNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}


