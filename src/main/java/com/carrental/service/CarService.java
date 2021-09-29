package com.carrental.service;

import com.carrental.entity.Car;
import com.carrental.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAllByStatus(1L);
    }

    public Car getCar(Long carId) {
        return carRepository.findByCarId(carId);
    }

    public Car save(Car car) {
        car.setStatus(1L);
        car.setCreatedBy("admin");
        car.setCreationDate(LocalDateTime.now());
        car.setUpdatedBy("admin");
        car.setUpdatedDate(LocalDateTime.now());
        return carRepository.save(car);
    }

    public Car update(Car car) {
        car.setUpdatedBy("admin");
        car.setUpdatedDate(LocalDateTime.now());
        return carRepository.save(car);
    }

    public void delete(Car car) {
        car.setStatus(0L);
        carRepository.save(car);
    }
}
