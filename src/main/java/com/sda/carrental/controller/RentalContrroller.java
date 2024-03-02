package com.sda.carrental.controller;


import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.service.serviceImpl.RentalServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/rentals")
@AllArgsConstructor
public class RentalContrroller {
    @Autowired
    private RentalServiceImpl rentalService;

    @PostMapping("/createRentals")
    public ResponseEntity<RentalEntity> createRentals(@RequestBody RentalEntity rental) {
        RentalEntity createdRental = rentalService.createRental(rental);
        return new ResponseEntity<>(createdRental, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{rentalId}")
    public ResponseEntity<Optional<RentalEntity>> getRentalById(@PathVariable Integer id) {
        Optional<RentalEntity> rental = rentalService.getRental(id);
        return new ResponseEntity<>(rental, HttpStatus.OK);
    }

    @PutMapping("/updateRental/{rentalId}")
    public ResponseEntity<RentalEntity> updateRental(@RequestBody RentalEntity rental, @PathVariable Integer id) {
        RentalEntity updatedRental = rentalService.updateRental(rental, id);
        return new ResponseEntity<>(updatedRental, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCRental/{rentalId}")
    public ResponseEntity<Void> deleteRental(@PathVariable Integer id) {
        rentalService.deleteRental(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
