package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.mapper.RoleMapper;
import com.etiya.identityservice.mapper.UserMapper;
import com.etiya.identityservice.repository.UserRepository;
import com.etiya.identityservice.service.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public List<GetAllUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return userMapper.userFromGetAllResponse(users);
    }

    @Override
    public GetByIdUserResponse getById(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        return userMapper.userFromGetByIdResponse(user);
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User user = userMapper.userFromCreateRequest(request);
        user.setCreatedDate(new Date());
        user.setStatus(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.userFromCreateResponse(user);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        User oldUser = userRepository.findById(request.getId()).orElseThrow();
        User newUser = userMapper.userFromUpdateRequest(request);
        newUser.setCreatedDate(oldUser.getCreatedDate());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(newUser);
        return userMapper.userFromUpdateResponse(newUser);
    }

    @Override
    public DeleteUserResponse delete(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return userMapper.userFromDeleteResponse(user.get());
        }
        return null;
    }

    @Override
    public Boolean isEmailRegistered(String email) {
        return userRepository.findByEmailIgnoreCase(email).isPresent();
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