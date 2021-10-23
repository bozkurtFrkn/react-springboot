package com.carrental.service;

import com.carrental.entity.User;
import com.carrental.repository.UserRepository;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<User> getAll() {
        return userRepository.findAllByStatus(1L);
    }

    public User findById(Long userId) {
        return userRepository.findByUserId(userId);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(1L);
        user.setCreatedBy("admin");
        user.setCreationDate(LocalDateTime.now());
        user.setUpdatedBy("admin");
        user.setUpdatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public User update(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUpdatedBy("admin");
        user.setUpdatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public void delete(User user) {
        user.setStatus(0L);
        userRepository.save(user);
    }
}
