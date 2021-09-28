package com.carrental.service;

import com.carrental.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    List<Car> getAllCars();
    Car save(Car car);
    Car update(Car car);
    void delete(Car car);
}
