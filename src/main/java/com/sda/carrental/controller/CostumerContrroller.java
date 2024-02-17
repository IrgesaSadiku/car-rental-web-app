package com.sda.carrental.controller;

import com.sda.carrental.service.serviceImpl.CostumerServiceImpl;
import com.sda.carrental.service.CostumerServiceInterface;
import lombok.AllArgsConstructor;
import com.sda.carrental.models.CostumerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/costumers")
@AllArgsConstructor
public class CostumerContrroller {
    private final CostumerServiceImpl costumerService;


    @PostMapping("/createCostumers")
    public ResponseEntity<CostumerEntity> createCostumers(@RequestBody CostumerEntity costumer) {
        CostumerEntity createdCostumer = CostumerServiceImpl.createCostumer(costumer);
        return new ResponseEntity<>(createdCostumer, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Optional<CostumerEntity>> getCostumerById(@PathVariable Integer id) {
        Optional<CostumerEntity> costumer = CostumerServiceImpl.getCostumer(id);
        return new ResponseEntity<>(costumer, HttpStatus.OK);
    }

    @PutMapping("/updateCostumer/{id}")
    public ResponseEntity<CostumerEntity> updateCostumer(@RequestBody CostumerEntity costumer, @PathVariable Integer id) {
        CostumerEntity updatedCostumer = CostumerServiceImpl.updateCostumer(costumer, id);
        return new ResponseEntity<>(updatedCostumer, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCostumer/{id}")
    public ResponseEntity<Void> deleteCostumer(@PathVariable Integer id) {
        CostumerServiceImpl.deleteCostumer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


