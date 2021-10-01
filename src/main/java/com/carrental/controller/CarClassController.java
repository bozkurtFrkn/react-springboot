package com.carrental.controller;

import com.carrental.entity.CarClass;
import com.carrental.service.CarClassService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/CarClass")
public class CarClassController {

    @Autowired
    private CarClassService carClassService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "AllCarClass", new ArrayList<>(Arrays.asList(carClassService.getAllCarClass())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long classId) {
        return Util.responseBody("/getById", "CarClass", new ArrayList<>(Arrays.asList(carClassService.getCarClass(classId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated CarClass carClass) {
        return Util.responseBody("/save", "SaveCarClass", new ArrayList<>(Arrays.asList(carClassService.save(carClass))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated CarClass carClass) {
        return Util.responseBody("/update", "UpdateCarClass", new ArrayList<>(Arrays.asList(carClassService.update(carClass))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated CarClass carClass) {
        carClassService.delete(carClass);
    }
}
