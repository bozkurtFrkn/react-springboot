package com.carrental.repository;

import com.carrental.entity.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long> {

    List<CarClass> findAllByStatus(Long status);

    CarClass findByClassId(Long classId);
}
