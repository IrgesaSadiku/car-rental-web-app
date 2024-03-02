package com.sda.carrental.controller;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.service.serviceImpl.BranchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/branches")
public class BranchContrroller {

    private final BranchServiceImpl branchService;

    @Autowired
    public BranchContrroller(BranchServiceImpl branchService) {
        this.branchService = branchService;
    }


    @GetMapping("/{branchId}")
    public ResponseEntity<BranchEntity> getBranchById(@PathVariable Integer branchId) {
        Optional<BranchEntity> branch = branchService.getBranch(branchId);
        return branch.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
//errors
//    @PostMapping
//    public ResponseEntity<BranchEntity> createBranch(@RequestBody BranchEntity branchEntity) {
//        BranchEntity createdBranch = branchService.saveBranch(BranchRepository);
//        return new ResponseEntity<>(createdBranch, HttpStatus.CREATED);
//    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Integer branchId) {
        branchService.deleteBranch(branchId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<BranchEntity>> getAllBranches() {
        List<BranchEntity> branches = branchService.getAllBranches();
        return new ResponseEntity<>(branches, HttpStatus.OK);
    }

    //  making a reservation(errors)
//    @PostMapping("/{branchId}/reservations")
//    public ResponseEntity<ReservationEntity> makeReservation(
//            @PathVariable Integer branchId,{
//        // Fetch the branch by ID
//        Optional<BranchEntity> branch = branchService.getBranch(branchId);

//        if (branch.isPresent()) {
//            // Assuming ReservationRequest contains necessary information for reservation
//            ReservationEntity reservation = branchService.makeReservation(
//                    branch.get(),
//                    request.get(),
//                    request.getCarEntity(),
//                    request.getStartDate(),
//                    request.getEndDate()
//            );

//            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
}

// Other methods for updating, canceling, or retrieving reservations as needed


