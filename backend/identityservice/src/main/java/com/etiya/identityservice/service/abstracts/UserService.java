package com.etiya.identityservice.service.abstracts;


import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService extends UserDetailsService {
    User create(User user);
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(UUID id);
    CreateUserResponse create(CreateUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
    DeleteUserResponse delete(UUID id);
    Boolean isEmailRegistered(String email);

}