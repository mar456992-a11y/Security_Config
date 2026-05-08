package com.example.security_config.controller;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

    UserDetails loadUserByUsername(String email);
}
