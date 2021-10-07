package com.carrental.service;

import com.carrental.entity.Parameter;
import com.carrental.repository.ParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParameterService {
    @Autowired
    private ParameterRepository parameterRepository;

    public List<Parameter> getAll() {
        return parameterRepository.findAllByStatus(1L);
    }

    public Parameter save(Parameter parameter) {
        parameter.setStatus(1L);
        parameter.setCreatedBy("admin");
        parameter.setCreationDate(LocalDateTime.now());
        parameter.setUpdatedBy("admin");
        parameter.setUpdatedDate(LocalDateTime.now());
        return parameterRepository.save(parameter);
    }

    public Parameter update(Parameter parameter) {
        parameter.setUpdatedBy("admin");
        parameter.setUpdatedDate(LocalDateTime.now());
        return parameterRepository.save(parameter);
    }

    public void delete(Parameter parameter) {
        parameter.setStatus(0L);
        parameterRepository.save(parameter);
    }
}
