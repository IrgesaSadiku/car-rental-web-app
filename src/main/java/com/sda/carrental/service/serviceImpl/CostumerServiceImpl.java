package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.CostumerNotFoundException;
import com.sda.carrental.models.CostumerEntity;
import com.sda.carrental.repository.CostumerRepository;
import com.sda.carrental.service.CostumerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerServiceInterface {
    @Autowired
    CostumerRepository costumerRepository;

    @Override
    public CostumerEntity createCostumer(CostumerEntity costumer) {
        return costumerRepository.save(costumer);
    }

    @Override
    public Optional<CostumerEntity> getCostumer(Integer costumerId) {
        return Optional.ofNullable(costumerRepository.findById(costumerId)
                .orElseThrow(() -> new CostumerNotFoundException("Costumer not found with this:" + costumerId)));

    }

    @Override
    public CostumerEntity updateCostumer(CostumerEntity costumer, Integer costumerId) {
        if (!costumerRepository.existsById(costumerId)) {
            throw new CostumerNotFoundException((" You can not update this costumer because it does not exist"));
        }
        Optional<CostumerEntity> costumerEntity = costumerRepository.findById(costumerId);
        costumerEntity.get().setFirstname(costumer.getFirstname());
        costumerEntity.get().setAdress(costumer.getAdress());
        return costumerRepository.save(costumerEntity.get());
    }

    @Override
    public void deleteCostumer(Integer costumerId) {
        costumerRepository.deleteById(costumerId);
    }


}


