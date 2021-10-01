package com.carrental.controller;

import com.carrental.entity.Car;
import com.carrental.entity.Parameter;
import com.carrental.service.CarService;
import com.carrental.service.ParameterService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/Parameter")
public class ParametreController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "AllParameters", new ArrayList<>(Arrays.asList(parameterService.getAllParameters())));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated Parameter parameter) {
        return Util.responseBody("/save", "SaveParameter", new ArrayList<>(Arrays.asList(parameterService.save(parameter))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Parameter parameter) {
        return Util.responseBody("/update", "UpdateParameter", new ArrayList<>(Arrays.asList(parameterService.update(parameter))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated Parameter parameter) {
        parameterService.delete(parameter);
    }
}
