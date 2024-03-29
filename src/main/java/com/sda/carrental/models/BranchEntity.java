package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Table(name = "branch")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity


public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "branch_id")
    private Integer branch_id;
    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "branchEntity")
    private List<ReservationEntity> reservationEntities;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rental_id", nullable = false)
    private RentalEntity rentalEntity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "branchEntity")
    private List<RevenueEntity> revenueEntities;

}
