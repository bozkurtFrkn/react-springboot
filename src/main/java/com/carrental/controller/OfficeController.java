package com.carrental.controller;

import com.carrental.entity.CarClass;
import com.carrental.entity.Office;
import com.carrental.service.CarClassService;
import com.carrental.service.OfficeService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/Office")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "AllOffice", new ArrayList<>(Arrays.asList(officeService.getAllOffice())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long officeId) {
        return Util.responseBody("/getById", "Office", new ArrayList<>(Arrays.asList(officeService.getOffice(officeId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated Office office) {
        return Util.responseBody("/save", "SaveOffice", new ArrayList<>(Arrays.asList(officeService.save(office))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Office office) {
        return Util.responseBody("/update", "UpdateOffice", new ArrayList<>(Arrays.asList(officeService.update(office))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated Office office) {
        officeService.delete(office);
    }
}
