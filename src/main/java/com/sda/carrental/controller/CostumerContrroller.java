package com.sda.carrental.controller;

import com.sda.carrental.models.CostumerEntity;
import com.sda.carrental.service.serviceImpl.CostumerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/costumers")
@AllArgsConstructor
public class CostumerContrroller {
    @Autowired
    private  CostumerServiceImpl costumerService;


    @PostMapping("/createCostumers")
    public ResponseEntity<CostumerEntity> createCostumers(@RequestBody CostumerEntity costumer) {
        CostumerEntity createdCostumer = costumerService.createCostumer(costumer);
        return new ResponseEntity<>(createdCostumer, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<CostumerEntity>> getCostumerById(@PathVariable Integer id) {
        Optional<CostumerEntity> costumer = costumerService.getCostumer(id);
        return new ResponseEntity<>(costumer, HttpStatus.OK);
    }

    @PutMapping("/updateCostumer/{id}")
    public ResponseEntity<CostumerEntity> updateCostumer(@RequestBody CostumerEntity costumer, @PathVariable Integer id) {
        CostumerEntity updatedCostumer = costumerService.updateCostumer(costumer, id);
        return new ResponseEntity<>(updatedCostumer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCostumer/{id}")
    public ResponseEntity<Void> deleteCostumer(@PathVariable Integer id) {
        costumerService.deleteCostumer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


