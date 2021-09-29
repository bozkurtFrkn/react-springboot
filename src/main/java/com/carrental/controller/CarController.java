package com.carrental.controller;

import com.carrental.entity.Car;
import com.carrental.service.CarService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/getAllCars")
    public ResponseEntity<?> getAllCars() {
        return Util.responseBody("/getAllCars", "AllCars", new ArrayList<>(Arrays.asList(carService.getAllCars())));
    }

    @GetMapping("/getCar")
    public ResponseEntity<?> getCar(@RequestParam Long carId) {
        return Util.responseBody("/getAllCars", "Car", new ArrayList<>(Arrays.asList(carService.getCar(carId))));
    }

    @PostMapping("/saveCar")
    public ResponseEntity<?> saveCar(@RequestBody @Validated Car car) {
        return Util.responseBody("/saveCar", "SaveCar", new ArrayList<>(Arrays.asList(carService.save(car))));
    }

    @PutMapping("/updateCar")
    public ResponseEntity<?> updateCar(@RequestBody @Validated Car car) {
        return Util.responseBody("/saveCar", "UpdateCar", new ArrayList<>(Arrays.asList(carService.update(car))));
    }

    @DeleteMapping("/deleteCar")
    public void deleteCar(@RequestBody @Validated Car car) {
        carService.delete(car);
    }
}
