package com.carrental.controller;

import com.carrental.entity.Reservation;
import com.carrental.service.ReservationService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        return Util.responseBody("/getAll", "Reservations", new ArrayList<>(Arrays.asList(reservationService.getAll())));
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Long reservationId) {
        return Util.responseBody("/getById", "Reservation", new ArrayList<>(Arrays.asList(reservationService.getById(reservationId))));
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Validated Reservation reservation) {
        return Util.responseBody("/save", "Reservation", new ArrayList<>(Arrays.asList(reservationService.save(reservation))));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Validated Reservation reservation) {
        return Util.responseBody("/update", "Reservation", new ArrayList<>(Arrays.asList(reservationService.update(reservation))));
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody @Validated Reservation reservation) {
        reservationService.delete(reservation);
    }
}
