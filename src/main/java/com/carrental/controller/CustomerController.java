package com.carrental.controller;

import com.carrental.entity.Customer;
import com.carrental.service.CustomerService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "Customers", new ArrayList<>(Arrays.asList(customerService.getAll())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long customerId) {
        return Util.responseBody("/getById", "Customer", new ArrayList<>(Arrays.asList(customerService.getById(customerId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated Customer customer) {
        return Util.responseBody("/save", "Customer", new ArrayList<>(Arrays.asList(customerService.save(customer))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Customer customer) {
        return Util.responseBody("/update", "Customer", new ArrayList<>(Arrays.asList(customerService.update(customer))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated Customer customer) {
        customerService.delete(customer);
    }
}
