package com.carrental.repository;

import com.carrental.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {
    List<Parameter> findAllByStatus(Long status);
}
