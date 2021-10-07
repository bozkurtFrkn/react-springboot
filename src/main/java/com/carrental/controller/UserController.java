package com.carrental.controller;

import com.carrental.entity.User;
import com.carrental.service.UserService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/User")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "Users", new ArrayList<>(Arrays.asList(userService.getAll())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long reservationId) {
        return Util.responseBody("/getById", "User", new ArrayList<>(Arrays.asList(userService.getById(reservationId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated User user) {
        return Util.responseBody("/save", "User", new ArrayList<>(Arrays.asList(userService.save(user))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated User user) {
        return Util.responseBody("/update", "User", new ArrayList<>(Arrays.asList(userService.update(user))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated User user) {
        userService.delete(user);
    }
}
