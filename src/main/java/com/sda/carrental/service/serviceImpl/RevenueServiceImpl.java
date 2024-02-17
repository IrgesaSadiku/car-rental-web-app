package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.BranchNotFoundException;
import com.sda.carrental.exceptions.RevenueNotFoundException;
import com.sda.carrental.models.BranchEntity;
import com.sda.carrental.models.RevenueEntity;
import com.sda.carrental.repository.BranchRepository;
import com.sda.carrental.repository.RevenueRepository;
import com.sda.carrental.service.RevenueServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RevenueServiceImpl implements RevenueServiceInterface {
    @Autowired
    RevenueRepository revenueRepository;
    @Override
    public RevenueEntity createRevenue(RevenueEntity revenue) {
        return revenueRepository.save(revenue);
        }

    @Override
    public Optional<RevenueEntity> getRevenue(Integer revenueId) {
        return Optional.ofNullable(revenueRepository.findById(revenueId)
                .orElseThrow(()-> new RevenueNotFoundException("Revenue not found with this:" + revenueId)));
    }

    @Override
    public RevenueEntity updateRevenue(RevenueEntity revenue, Integer revenueId) {
        if(!revenueRepository.existsById(revenueId)){
            throw new BranchNotFoundException((" You can not update this revenue because it does not exist"));
        }
        Optional<RevenueEntity> revenueEntity = revenueRepository.findById(revenueId);
        revenueEntity.get().setRevenue_amount(revenue.getRevenue_amount());
        revenueEntity.get().setRevenue_id(revenue.getRevenue_id());
        return revenueRepository.save(revenueEntity.get());
    }

    @Override
    public void deleteRevenue(Integer revenueId) {
        revenueRepository.deleteById(revenueId);
    }
}
