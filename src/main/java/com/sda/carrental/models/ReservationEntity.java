package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity

public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "reservation_id")
    private Integer reservation_id;
    @Column(name="return_date")
    private Date return_date;
    @Column(name="revenue_amount")
    private Integer revenue_amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="branch_id", nullable = false)
    private BranchEntity branchEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="car_id", nullable = false)
    private CarEntity carEntity;


}
