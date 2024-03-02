package com.sda.carrental.controller;


import com.sda.carrental.models.CarEntity;
import com.sda.carrental.service.serviceImpl.CarServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarContrroller {
    @Autowired
    private CarServiceImpl carService;


    @PostMapping("/createCars")
    public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity car) {
        CarEntity createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{carId}")
    public ResponseEntity<Optional<CarEntity>> getCarById(@PathVariable Integer id) {
        Optional<CarEntity> car = carService.getCar(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PutMapping("/updateCar/{carId}")
    public ResponseEntity<CarEntity> updateCar(@RequestBody CarEntity car, @PathVariable Integer id) {
        CarEntity updatedCar = carService.updateCar(car, id);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
