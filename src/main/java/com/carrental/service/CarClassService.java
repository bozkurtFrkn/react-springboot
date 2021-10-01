package com.carrental.service;

import com.carrental.entity.CarClass;
import com.carrental.repository.CarClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarClassService {
    @Autowired
    private CarClassRepository carClassRepository;

    public List<CarClass> getAllCarClass() {
        return carClassRepository.findAllByStatus(1L);
    }

    public CarClass getCarClass(Long classId) {
        return carClassRepository.findByClassId(classId);
    }

    public CarClass save(CarClass carClass) {
        carClass.setStatus(1L);
        carClass.setCreatedBy("admin");
        carClass.setCreationDate(LocalDateTime.now());
        carClass.setUpdatedBy("admin");
        carClass.setUpdatedDate(LocalDateTime.now());
        return carClassRepository.save(carClass);
    }

    public CarClass update(CarClass carClass) {
        carClass.setUpdatedBy("admin");
        carClass.setUpdatedDate(LocalDateTime.now());
        return carClassRepository.save(carClass);
    }

    public void delete(CarClass carClass) {
        carClass.setStatus(0L);
        carClassRepository.save(carClass);
    }

}
