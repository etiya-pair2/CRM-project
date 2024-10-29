package com.etiya.identityservice.rules;

import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AuthBusinessRules {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public void checkIfEmailExist(String email) {
        Optional<User> userOptional = userRepository.findByEmailIgnoreCase(email);
        if (userOptional.isPresent()) {
//            throw new BusinessException(Messages.USER_EMAIL_ALREADY_EXISTS);
        }
    }





}
