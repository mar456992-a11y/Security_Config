package com.example.security_config.service;

import com.example.security_config.model.entity.Auth;
import com.example.security_config.model.request.LoginRequest;
import com.example.security_config.model.request.RegisterRequest;
import com.example.security_config.model.response.LoginResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {

    Auth register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

    Object logoutAll(String email);
}