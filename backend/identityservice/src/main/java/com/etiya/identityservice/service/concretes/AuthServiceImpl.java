package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.Auth.LoginRequest;
import com.etiya.identityservice.dto.Auth.RegisterRequest;
import com.etiya.identityservice.dto.Auth.TokenResponse;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.rules.AuthBusinessRules;
import com.etiya.identityservice.service.abstracts.AuthService;
import com.etiya.identityservice.service.abstracts.UserService;
import io.github.sabaurgup.security.BaseJwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService
{
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final BaseJwtService baseJwtService;
    private final AuthBusinessRules authBusinessRules;


    @Override
    public TokenResponse login(LoginRequest loginRequest) {
        UserDetails user = userService.loadUserByUsername(loginRequest.getEmail());
        boolean passwordMatching = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        if(!passwordMatching)
            throw new RuntimeException("E-posta veya şifre hatalı.");
        return new TokenResponse(baseJwtService.generateToken(user.getUsername()), true);
    }

    @Transactional
    @Override
    public TokenResponse register(RegisterRequest registerRequest) {
        authBusinessRules.checkIfEmailExist( registerRequest.getEmail());

        User userToAdd = new User();
        userToAdd.setEmail(registerRequest.getEmail());
        userToAdd.setName(registerRequest.getName());
        userToAdd.setSurname(registerRequest.getSurname());
        userToAdd.setIdentityNo(registerRequest.getIdentityNo());
        userToAdd.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        User user = userService.create(userToAdd);
        return new TokenResponse(baseJwtService.generateToken(user.getUsername()), true);
    }


}