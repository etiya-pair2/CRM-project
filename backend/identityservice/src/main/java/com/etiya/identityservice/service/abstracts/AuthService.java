package com.etiya.identityservice.service.abstracts;

import com.etiya.identityservice.dto.Auth.LoginRequest;
import com.etiya.identityservice.dto.Auth.RegisterRequest;
import com.etiya.identityservice.dto.Auth.TokenResponse;

public interface AuthService {
    TokenResponse login(LoginRequest loginRequest);
    TokenResponse register(RegisterRequest registerRequest);
}