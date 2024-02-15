package com.sda.carrental.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@Table(name = "costumer")
@NoArgsConstructor
@AllArgsConstructor
@jakarta.persistence.Entity
public class CostumerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name = "costumer_id")
    private Integer costumer_id;


    @Column(name= "Firstname")
    private String Firstname;

    @Column(name= "Lastname")
    private String Lastname;

    @Column(name= "email")
    private String email;


    @Column(name= "adress")
    private String adress;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "costumerEntity")
//    private List<ReservationEntity> reservationEntities;

}
