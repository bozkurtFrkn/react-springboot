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
@RequestMapping("/api")
public class CarClassController {

    @Autowired
    private CarClassService carClassService;

    @GetMapping("/getAllCarClass")
    public ResponseEntity<?> getAllCarClass() {
        return Util.responseBody("/getAllCarClass", "AllCarClass", new ArrayList<>(Arrays.asList(carClassService.getAllCarClass())));
    }

    @GetMapping("/getCarClass")
    public ResponseEntity<?> getCarClass(@RequestParam Long classId) {
        return Util.responseBody("/getCarClass", "CarClass", new ArrayList<>(Arrays.asList(carClassService.getCarClass(classId))));
    }

    @PostMapping("/saveCarClass")
    public ResponseEntity<?> saveCarClass(@RequestBody @Validated CarClass carClass) {
        return Util.responseBody("/saveCarClass", "SaveCarClass", new ArrayList<>(Arrays.asList(carClassService.save(carClass))));
    }

    @PutMapping("/updateCarClass")
    public ResponseEntity<?> updateCarClass(@RequestBody @Validated CarClass carClass) {
        return Util.responseBody("/updateCarClass", "UpdateCarClass", new ArrayList<>(Arrays.asList(carClassService.update(carClass))));
    }

    @DeleteMapping("/deleteCarClass")
    public void deleteCarClass(@RequestBody @Validated CarClass carClass) {
        carClassService.delete(carClass);
    }
}
