package com.carrental.auth;

import com.carrental.entity.User;
import com.carrental.service.UserService;
import com.carrental.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthUser authUser) throws Exception{
        User user = userService.findByUsername(authUser.getUsername());
        if (user != null){
            Boolean isMatched = passwordEncoder.matches(authUser.getPassword(), user.getPassword());
            if (!isMatched){
                throw new Exception("Kullanici adi veya parola hatali !!");
            }
            final String token = tokenManager.generateToken(user.getUsername());
            return Util.responseBody("/login", "Token", new ArrayList<>(Arrays.asList(token)));
        } else {
            throw new Exception("Kullanici bulunamadi !!");
        }
    }
}
