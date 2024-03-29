package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.RentalNotFoundException;
import com.sda.carrental.exceptions.ReservationNotFoundException;
import com.sda.carrental.models.RentalEntity;
import com.sda.carrental.repository.RentalRepository;
import com.sda.carrental.service.RentalServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalServiceInterface {
    @Autowired
    RentalRepository rentalRepository;

    @Override
    public RentalEntity createRental(RentalEntity rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public Optional<RentalEntity> getRental(Integer rentalId) {
        return Optional.ofNullable(rentalRepository.findById(rentalId)
                .orElseThrow(() -> new RentalNotFoundException("Rental not found with this:" + rentalId)));
    }

    @Override
    public RentalEntity updateRental(RentalEntity rental, Integer rentalId) {
        if (!rentalRepository.existsById(rentalId)) {
            throw new ReservationNotFoundException((" You can not update this rental because it does not exist"));
        }
        Optional<RentalEntity> rentalEntity = rentalRepository.findById(rentalId);
        rentalEntity.get().setRental_id(rental.getRental_id());
        rentalEntity.get().setName(rental.getName());
        rentalEntity.get().setOwner(rental.getOwner());
        rentalEntity.get().setEmail(rental.getEmail());
        return rentalRepository.save(rentalEntity.get());
    }

    @Override
    public void deleteRental(Integer RentalId) {
        rentalRepository.deleteById(RentalId);
    }
}
