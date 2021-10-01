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
@RequestMapping("/api/Car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "AllCars", new ArrayList<>(Arrays.asList(carService.getAllCars())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long carId) {
        return Util.responseBody("/getById", "Car", new ArrayList<>(Arrays.asList(carService.getCar(carId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated Car car) {
        return Util.responseBody("/save", "SaveCar", new ArrayList<>(Arrays.asList(carService.save(car))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Car car) {
        return Util.responseBody("/update", "UpdateCar", new ArrayList<>(Arrays.asList(carService.update(car))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated Car car) {
        carService.delete(car);
    }
}
