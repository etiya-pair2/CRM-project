package com.etiya.identityservice.rules;

import com.etiya.identityservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserBusinesRules {

    private final UserRepository userRepository;


}
