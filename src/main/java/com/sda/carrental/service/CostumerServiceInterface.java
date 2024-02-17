package com.sda.carrental.service;
import com.sda.carrental.models.CostumerEntity;

import java.util.Optional;

public interface CostumerServiceInterface  {
    CostumerEntity createCostumer(CostumerEntity costumer);

    Optional<CostumerEntity> getCostumer(Integer costumerId);

    CostumerEntity updateCostumer(CostumerEntity costumer, Integer costumerId);

    void deleteCostumer(Integer costumerId);


}
