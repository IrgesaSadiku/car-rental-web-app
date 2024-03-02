package com.sda.carrental.controller;


import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.service.serviceImpl.ReservationServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationContrroller {
    @Autowired
    private ReservationServiceImpl reservationService;

    @PostMapping("/createReservations")
    public ResponseEntity<ReservationEntity> createReservations(@RequestBody ReservationEntity reservation) {
        ReservationEntity createdReservation = reservationService.createReservation(reservation);
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @GetMapping("/getReservationById/{id}")
    public ResponseEntity<Optional<ReservationEntity>> getReservationById(@PathVariable Integer id) {
        Optional<ReservationEntity> reservation = reservationService.getReservation(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PutMapping("/updateReservation/{id}")
    public ResponseEntity<ReservationEntity> updateReservation(@RequestBody ReservationEntity reservation, @PathVariable Integer id) {
        ReservationEntity updatedReservation = reservationService.updateReservation(reservation, id);
        return new ResponseEntity<>(updatedReservation, HttpStatus.OK);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Integer id) {
        reservationService.deleteReservation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
