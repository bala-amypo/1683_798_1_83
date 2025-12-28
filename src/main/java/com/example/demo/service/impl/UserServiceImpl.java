package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.security.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final JwtTokenProvider jwtTokenProvider =
            new JwtTokenProvider("MySuperSecretVendorSlaKey1234567890", 3600000L);

    @Override
    public User register(User user) {
        user.setId(1L); // dummy
        user.setRole("USER");
        return user;
    }

    @Override
    public String login(User user) {
        return jwtTokenProvider.createToken(
                user.getEmail(),
                "USER",
                1L
        );
    }
}