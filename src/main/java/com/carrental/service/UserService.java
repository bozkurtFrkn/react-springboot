package com.carrental.service;

import com.carrental.entity.User;
import com.carrental.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAllByStatus(1L);
    }

    public User getById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public User save(User user) {
        user.setStatus(1L);
        user.setCreatedBy("admin");
        user.setCreationDate(LocalDateTime.now());
        user.setUpdatedBy("admin");
        user.setUpdatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User update(User user) {
        user.setUpdatedBy("admin");
        user.setUpdatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void delete(User user) {
        user.setStatus(0L);
        userRepository.save(user);
    }
}
