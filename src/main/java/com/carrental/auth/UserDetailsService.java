package com.carrental.auth;

import com.carrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.carrental.entity.User user = userService.findByUsername(username);
        if (username.equalsIgnoreCase(user.getUsername())) {
            return new UserDetail(user);
//            return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
