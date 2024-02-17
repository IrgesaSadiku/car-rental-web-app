package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.exceptions.ReservationNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.ReservationRepository;
import com.sda.carrental.service.BranchServiceInterface;
import com.sda.carrental.service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ReservationServiceImpl implements ReservationServiceInterface {
    @Autowired
    ReservationRepository reservationRepository;
    @Override
    public ReservationEntity createReservation(ReservationEntity reservation) {
         return reservationRepository.save(reservation);
    }
    @Override
    public Optional<ReservationEntity> getReservation(Integer reservationId) {
        return Optional.ofNullable(reservationRepository.findById(reservationId)
                .orElseThrow(()-> new ReservationNotFoundException("Reservation not found with this:" + reservationId)));
    }

    @Override
    public ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId) {
        if(!reservationRepository.existsById(reservationId)){
            throw new BranchNotFoundException((" You can not update this reservation because it does not exist"));
        }
        Optional<ReservationEntity> reservationEntity = reservationRepository.findById(reservationId);
        reservationEntity.get().setReservation_id(reservation.getReservation_id());
        reservationEntity.get().setReturn_date(reservation.getReturn_date());
        return reservationRepository.save(reservationEntity.get());
    }

    @Override
    public void deleteReservation(Integer reservationId) {
        reservationRepository.deleteById(reservationId);
    }

}

