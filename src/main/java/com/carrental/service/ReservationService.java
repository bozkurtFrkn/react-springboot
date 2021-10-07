package com.carrental.service;

import com.carrental.entity.Reservation;
import com.carrental.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAllByStatus(1L);
    }

    public Reservation getById(Long reservationId) {
        return reservationRepository.findByReservationId(reservationId);
    }

    public Reservation save(Reservation reservation) {
        reservation.setStatus(1L);
        reservation.setCreatedBy("admin");
        reservation.setCreationDate(LocalDateTime.now());
        reservation.setUpdatedBy("admin");
        reservation.setUpdatedDate(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public Reservation update(Reservation reservation) {
        reservation.setUpdatedBy("admin");
        reservation.setUpdatedDate(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    public void delete(Reservation reservation) {
        reservation.setStatus(0L);
        reservationRepository.save(reservation);
    }
}
