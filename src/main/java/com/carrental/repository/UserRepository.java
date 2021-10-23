package com.carrental.repository;

import com.carrental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByStatus(Long status);

    User findByUserId(Long userId);

    User findByUsername(String username);
}
