package com.sda.carrental.service.serviceImpl;

import com.sda.carrental.exceptions.CarNotFoundException;
import com.sda.carrental.models.CarEntity;
import com.sda.carrental.repository.CarRepository;
import com.sda.carrental.service.CarServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarServiceInterface {
    @Autowired
    CarRepository carRepository;


    @Override
    public CarEntity createCar(CarEntity car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<CarEntity> getCar(Integer carId) {
        return Optional.ofNullable(carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Car not found with this:" + carId)));
    }

    @Override
    public CarEntity updateCar(CarEntity car, Integer carId) {
        if (!carRepository.existsById(carId)) {
            throw new CarNotFoundException((" You can not update this Car because it does not exist"));
        }
        Optional<CarEntity> carEntity = carRepository.findById(carId);
        carEntity.get().setCar_id(car.getCar_id());
        carEntity.get().setBrand(car.getBrand());
        carEntity.get().setModel(car.getModel());
        return carRepository.save(carEntity.get());
    }

    @Override
    public void deleteCar(Integer CarId) {
        carRepository.deleteById(CarId);
    }
}
