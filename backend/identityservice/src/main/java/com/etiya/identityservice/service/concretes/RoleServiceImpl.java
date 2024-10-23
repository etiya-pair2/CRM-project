package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.Role.*;
import com.etiya.identityservice.entity.Role;
import com.etiya.identityservice.mapper.RoleMapper;
import com.etiya.identityservice.repository.RoleRepository;
import com.etiya.identityservice.service.abstracts.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
    @Service
    @RequiredArgsConstructor
    public class RoleServiceImpl implements RoleService {
        private final RoleRepository roleRepository;

        @Override
        public List<GetAllRoleResponse> getAll() {
            List<Role> roles = roleRepository.findAll();
            return RoleMapper.INSTANCE.roleFromGetAllResponse(roles);
        }

        @Override
        public GetByIdRoleResponse getById(UUID id) {
            Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
            return RoleMapper.INSTANCE.roleFromGetByIdResponse(role);
        }

        @Override
        public CreateRoleResponse create(CreateRoleRequest request) {
            Role role = RoleMapper.INSTANCE.roleFromCreateRequest(request);
            roleRepository.save(role);
            return RoleMapper.INSTANCE.roleFromCreateResponse(role);
        }

        @Override
        public UpdateRoleResponse update(UpdateRoleRequest request) {
            Role role = RoleMapper.INSTANCE.roleFromUpdateRequest(request);
            roleRepository.save(role);
            return RoleMapper.INSTANCE.roleFromUpdateResponse(role);
        }

        @Override
        public DeleteRoleResponse delete(UUID id) {
            Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
            roleRepository.delete(role);
            return RoleMapper.INSTANCE.roleFromDeleteResponse(role);
        }
    }

