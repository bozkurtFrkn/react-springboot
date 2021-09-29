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
@RequestMapping("/api")
public class ParametreController {
    @Autowired
    private ParameterService parameterService;

    @GetMapping("/getAllParameters")
    public ResponseEntity<?> getAllParameters() {
        return Util.responseBody("/getAllParameters", "AllParameters", new ArrayList<>(Arrays.asList(parameterService.getAllParameters())));
    }

    @PostMapping("/saveParameter")
    public ResponseEntity<?> saveParameter(@RequestBody @Validated Parameter parameter) {
        return Util.responseBody("/saveParameter", "SaveParameter", new ArrayList<>(Arrays.asList(parameterService.save(parameter))));
    }

    @PutMapping("/updateParameter")
    public ResponseEntity<?> updateParameter(@RequestBody @Validated Parameter parameter) {
        return Util.responseBody("/updateParameter", "UpdateParameter", new ArrayList<>(Arrays.asList(parameterService.update(parameter))));
    }

    @DeleteMapping("/deleteParameter")
    public void deleteParameter(@RequestBody @Validated Parameter parameter) {
        parameterService.delete(parameter);
    }
}
