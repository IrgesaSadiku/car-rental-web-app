package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.models.CostumerEntity;
import com.sda.carrental.models.ReservationEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.service.BranchServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BranchServiceImpl implements BranchServiceInterface {
    @Autowired
    BranchRepository branchRepository;

    @Override
    public BranchEntity createBranch(BranchEntity branch) {
        return branchRepository.save(branch);
    }

    @Override
    public Optional<BranchEntity> getBranch(Integer branchId) {
        return Optional.ofNullable(branchRepository.findById(branchId)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found with this:" + branchId)));

    }

    @Override
    public BranchEntity updateBranch(BranchEntity branch, Integer branchId) {
        if (!branchRepository.existsById(branchId)) {
            throw new BranchNotFoundException((" You can not update this branch because it does not exist"));
        }
        Optional<BranchEntity> branchEntity = branchRepository.findById(branchId);
        branchEntity.get().setCity(branch.getCity());
        branchEntity.get().setAddress(branch.getAddress());
        return branchRepository.save(branchEntity.get());
    }

    @Override
    public void deleteBranch(Integer branchId) {
        branchRepository.deleteById(branchId);
    }


    //car reservation and booking
    public ReservationEntity makeReservation(BranchEntity branchEntity, CostumerEntity customerEntity, CarEntity carEntity, Date startDate, Date endDate) {
        // Business logic and validation checks

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setBranchEntity(branchEntity);
        reservationEntity.setReservation_id(reservationEntity.getReservation_id());
        reservationEntity.setCarEntity(carEntity);
        reservationEntity.setReturn_date(reservationEntity.getReturn_date());
        reservationEntity.setRevenue_amount(reservationEntity.getRevenue_amount());

        branchEntity.getReservationEntities().add(reservationEntity);
        branchRepository.save(branchEntity);

        return reservationEntity;
    }

    public List<ReservationEntity> getReservationsByBranch(BranchEntity branchEntity) {
        return branchEntity.getReservationEntities();
    }

    public List<BranchEntity> getAllBranches() {
        return branchRepository.findAll();
    }
}


