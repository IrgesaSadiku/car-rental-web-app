package com.sda.carrental.service;

import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.CostumerEntity;
import com.sda.carrental.models.ReservationEntity;

import java.util.Date;
import java.util.Optional;

public interface ReservationServiceInterface {
    ReservationEntity createReservation(ReservationEntity reservation);

    Optional<ReservationEntity> getReservation(Integer reservationId);

    ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId);

    void deleteReservation(Integer reservationId);

    ReservationEntity makeReservation(BranchEntity branchEntity, CostumerEntity customerEntity, CarEntity carEntity, Date startDate, Date endDate);

}
