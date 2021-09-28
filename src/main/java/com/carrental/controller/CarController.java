package com.carrental.controller;

import com.carrental.entity.Car;
import com.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("/getAllCars")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
}
