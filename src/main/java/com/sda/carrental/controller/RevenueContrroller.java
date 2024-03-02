package com.sda.carrental.controller;

import com.sda.carrental.models.RevenueEntity;
import com.sda.carrental.service.serviceImpl.RevenueServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/revenues")
@AllArgsConstructor
public class RevenueContrroller {
    @Autowired
    private RevenueServiceImpl revenueService;


    @PostMapping("/createRevenues")
    public ResponseEntity<RevenueEntity> createRevenues(@RequestBody RevenueEntity revenue) {
        RevenueEntity createdRevenue = revenueService.createRevenue(revenue);
        return new ResponseEntity<>(createdRevenue, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{revenueId}")
    public ResponseEntity<Optional<RevenueEntity>> getRevenueById(@PathVariable Integer id) {
        Optional<RevenueEntity> revenue = revenueService.getRevenue(id);
        return new ResponseEntity<>(revenue, HttpStatus.OK);
    }

    @PutMapping("/updateCostumer/{revenueId}")
    public ResponseEntity<RevenueEntity> updateRevenue(@RequestBody RevenueEntity revenue, @PathVariable Integer id) {
        RevenueEntity updatedRevenue = revenueService.updateRevenue(revenue, id);
        return new ResponseEntity<>(updatedRevenue, HttpStatus.OK);
    }

    @DeleteMapping("/deleteRevenue/{revenueId}")
    public ResponseEntity<Void> deleteRevenue(@PathVariable Integer id) {
        revenueService.deleteRevenue(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
