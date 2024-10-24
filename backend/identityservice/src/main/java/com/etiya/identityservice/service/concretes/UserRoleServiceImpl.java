package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.UserRole.*;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.entity.UserRole;
import com.etiya.identityservice.mapper.RoleMapper;
import com.etiya.identityservice.mapper.UserRoleMapper;

import com.etiya.identityservice.repository.UserRoleRepository;
import com.etiya.identityservice.service.abstracts.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    UserRoleMapper userRoleMapper = UserRoleMapper.INSTANCE;


    @Override
    public List<GetAllUserRoleResponse> getAll() {
        List<UserRole> userRoles= userRoleRepository.findAll();
        System.out.println(userRoles.get(0).getRole());
        return userRoleMapper.userRoleFromGetAllResponse(userRoles);

    }

    @Override
    public GetByIdUserRoleResponse getById(UUID id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserRole not found"));
        return userRoleMapper.userRoleFromGetByIdResponse(userRole);
    }

    @Override
    public CreateUserRoleResponse create(CreateUserRoleRequest request) {
        UserRole userRole = userRoleMapper.userRoleFromCreateRequest(request);
        userRole.setCreatedDate(new Date());
        userRole.setStatus(true);
        userRoleRepository.save(userRole);
        return userRoleMapper.userRoleFromCreateResponse(userRole);
    }

    @Override
    public UpdateUserRoleResponse update(UpdateUserRoleRequest request) {
        UserRole oldUserRole = userRoleRepository.findById(request.getId()).orElseThrow();
        UserRole newUserRole = userRoleMapper.userRoleFromUpdateRequest(request);
        newUserRole.setCreatedDate(oldUserRole.getCreatedDate());
        userRoleRepository.save(newUserRole);
            return userRoleMapper.userRoleFromUpdateResponse(newUserRole);
    }

    @Override
    public DeleteUserRoleResponse delete(UUID id) {
        Optional<UserRole> userRole = userRoleRepository.findById(id);
        if (userRole.isPresent()) {
            userRoleRepository.delete(userRole.get());
            return userRoleMapper.userRoleFromDeleteResponse(userRole.get());
        }
        return null;
    }
    }

