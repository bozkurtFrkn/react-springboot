package com.carrental.repository;

import com.carrental.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByStatus(Long status);

    Customer findByCustomerId(Long customerId);
}
