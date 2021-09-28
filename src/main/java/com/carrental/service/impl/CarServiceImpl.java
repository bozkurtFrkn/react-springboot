package com.carrental.service.impl;

import com.carrental.entity.Car;
import com.carrental.repository.CarRepository;
import com.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car save(Car car) {
        car.setCreatedBy("1");
        car.setCreationDate(LocalDateTime.now());
        car.setUpdatedBy("1");
        car.setUpdatedDate(LocalDateTime.now());
        return carRepository.save(car);
    }

    @Override
    public Car update(Car car) {
        car.setUpdatedBy("1");
        car.setUpdatedDate(LocalDateTime.now());
        return carRepository.save(car);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }
}
