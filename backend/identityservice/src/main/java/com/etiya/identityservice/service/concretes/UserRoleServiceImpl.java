package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.UserRole.*;
import com.etiya.identityservice.entity.UserRole;
import com.etiya.identityservice.mapper.UserRoleMapper;

import com.etiya.identityservice.repository.UserRoleRepository;
import com.etiya.identityservice.service.abstracts.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;


    @Override
    public List<GetAllUserRoleResponse> getAll() {
        List<UserRole> userRoles= userRoleRepository.findAll();
        System.out.println(userRoles.get(0).getRole());
        return UserRoleMapper.INSTANCE.userRoleFromGetAllResponse(userRoles);

    }

    @Override
    public GetByIdUserRoleResponse getById(UUID id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserRole not found"));
        return UserRoleMapper.INSTANCE.userRoleFromGetByIdResponse(userRole);
    }

    @Override
    public CreateUserRoleResponse create(CreateUserRoleRequest request) {
        UserRole userRole = UserRoleMapper.INSTANCE.userRoleFromCreateRequest(request);
        userRoleRepository.save(userRole);
        return UserRoleMapper.INSTANCE.userRoleFromCreateResponse(userRole);
    }

    @Override
    public UpdateUserRoleResponse update(UpdateUserRoleRequest request) {
            UserRole userRole = UserRoleMapper.INSTANCE.userRoleFromUpdateRequest(request);
            userRoleRepository.save(userRole);
            return UserRoleMapper.INSTANCE.userRoleFromUpdateResponse(userRole);
    }

    @Override
    public DeleteUserRoleResponse delete(UUID id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserRole not found"));
        userRoleRepository.delete(userRole);
        return UserRoleMapper.INSTANCE.userRoleFromDeleteResponse(userRole);
    }
    }

