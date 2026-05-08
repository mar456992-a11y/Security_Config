package com.example.security_config.service.impl;

import com.example.security_config.model.entity.Auth;
import com.example.security_config.model.request.LoginRequest;
import com.example.security_config.model.request.RegisterRequest;
import com.example.security_config.model.response.LoginResponse;
import com.example.security_config.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public Auth register(RegisterRequest registerRequest) {

        Auth auth = new Auth();
        auth.setFullName(registerRequest.getUserName());
        auth.setEmail(registerRequest.getEmail());
        auth.setPassword(registerRequest.getPassword());

        // TODO: save to database later
        return auth;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        // TODO: validate user + generate JWT later
        return LoginResponse.builder()
                .token("dummy-token")
                .message("Login successful")
                .build();
    }

    @Override
    public Object logoutAll(String email) {

        // TODO: implement token invalidation later
        return "Logout success for " + email;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // TODO: fetch user from database
        Auth auth = new Auth();
        auth.setEmail(email);
        auth.setPassword("123");

        return auth;
    }
}