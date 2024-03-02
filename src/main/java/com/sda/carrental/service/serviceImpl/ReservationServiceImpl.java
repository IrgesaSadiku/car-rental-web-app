package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.ReservationNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.CostumerEntity;
import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.repository.ReservationRepository;
import com.sda.carrental.service.ReservationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
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
                .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with this:" + reservationId)));
    }

    @Override
    public ReservationEntity updateReservation(ReservationEntity reservation, Integer reservationId) {
        if (!reservationRepository.existsById(reservationId)) {
            throw new ReservationNotFoundException((" You can not update this reservation because it does not exist"));
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

    @Override
    public ReservationEntity makeReservation(BranchEntity branchEntity, CostumerEntity customerEntity, CarEntity carEntity, Date startDate, Date endDate) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setBranchEntity(branchEntity);
        reservationEntity.setReservation_id(reservationEntity.getReservation_id());
        reservationEntity.setCarEntity(carEntity);
        reservationEntity.setReturn_date(reservationEntity.getReturn_date());
        reservationEntity.setRevenue_amount(reservationEntity.getRevenue_amount());


//        branchEntity.getReservationEntities().add(reservationEntity);
//        BranchRepository.save(branchEntity);

        return reservationEntity;
    }


}

