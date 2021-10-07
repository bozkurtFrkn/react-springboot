package com.carrental.service;

import com.carrental.entity.Customer;
import com.carrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll() {
        return customerRepository.findAllByStatus(1L);
    }

    public Customer getById(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    public Customer save(Customer customer) {
        customer.setStatus(1L);
        customer.setCreatedBy("admin");
        customer.setCreationDate(LocalDateTime.now());
        customer.setUpdatedBy("admin");
        customer.setUpdatedDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer) {
        customer.setUpdatedBy("admin");
        customer.setUpdatedDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    public void delete(Customer customer) {
        customer.setStatus(0L);
        customerRepository.save(customer);
    }
}
