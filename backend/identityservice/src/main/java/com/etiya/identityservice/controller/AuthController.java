package com.etiya.identityservice.controller;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.etiya.identityservice.dto.Auth.LoginRequest;
import com.etiya.identityservice.dto.Auth.TokenResponse;
import com.etiya.identityservice.dto.Auth.RegisterRequest;
import com.etiya.identityservice.service.abstracts.AuthService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/identity/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AuthService authService;


    @PostMapping("login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }


    @PostMapping("register")
    public TokenResponse register(@RequestBody RegisterRequest registerRequest){
        TokenResponse tokenResponse = authService.register(registerRequest);
        return tokenResponse;
    }
}