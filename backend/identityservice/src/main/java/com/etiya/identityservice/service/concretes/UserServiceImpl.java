package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.mapper.UserMapper;
import com.etiya.identityservice.repository.UserRepository;
import com.etiya.identityservice.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return UserMapper.INSTANCE.userFromGetAllResponse(users);
    }

    @Override
    public GetByIdUserResponse getById(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        return UserMapper.INSTANCE.userFromGetByIdResponse(user);
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User user = UserMapper.INSTANCE.userFromCreateRequest(request);
        userRepository.save(user);
        return UserMapper.INSTANCE.userFromCreateResponse(user);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User user = UserMapper.INSTANCE.userFromUpdateRequest(request);
        userRepository.save(user);
        return UserMapper.INSTANCE.userFromUpdateResponse(user);
    }

    @Override
    public DeleteUserResponse delete(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return UserMapper.INSTANCE.userFromDeleteResponse(user);
    }

    @Override
    public User create(User user) {
        userRepository.save(user);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmailIgnoreCase(username)
                .orElseThrow(() -> new UsernameNotFoundException(""));
    }
}