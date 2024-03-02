package com.sda.carrental.repository;

import com.sda.carrental.models.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Integer> {
//    @Query("SELECT DISTINCT r.customerEntity FROM RentalEntity r")
//    List<CostumerEntity> findAllCustomers();
}
