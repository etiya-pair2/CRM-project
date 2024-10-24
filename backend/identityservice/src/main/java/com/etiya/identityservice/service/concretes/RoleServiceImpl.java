package com.etiya.identityservice.service.concretes;

import com.etiya.identityservice.dto.Role.*;
import com.etiya.identityservice.entity.Role;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.mapper.RoleMapper;
import com.etiya.identityservice.repository.RoleRepository;
import com.etiya.identityservice.service.abstracts.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
    @Service
    @RequiredArgsConstructor
    public class RoleServiceImpl implements RoleService {
        private final RoleRepository roleRepository;
        RoleMapper roleMapper = RoleMapper.INSTANCE;

        @Override
        public List<GetAllRoleResponse> getAll() {
            List<Role> roles = roleRepository.findAll();
            return roleMapper.roleFromGetAllResponse(roles);
        }

        @Override
        public GetByIdRoleResponse getById(UUID id) {
            Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
            return roleMapper.roleFromGetByIdResponse(role);
        }

        @Override
        public CreateRoleResponse create(CreateRoleRequest request) {
            Role role = roleMapper.roleFromCreateRequest(request);
            role.setCreatedDate(new Date());
            role.setStatus(true);
            roleRepository.save(role);
            return roleMapper.roleFromCreateResponse(role);
        }

        @Override
        public UpdateRoleResponse update(UpdateRoleRequest request) {
            Role oldRole = roleRepository.findById(request.getId()).orElseThrow();
            Role newRole = roleMapper.roleFromUpdateRequest(request);
            newRole.setCreatedDate(oldRole.getCreatedDate());
            roleRepository.save(newRole);
            return roleMapper.roleFromUpdateResponse(newRole);
        }

        @Override
        public DeleteRoleResponse delete(UUID id) {
            Optional<Role> role = roleRepository.findById(id);
            if (role.isPresent()) {
                roleRepository.delete(role.get());
                return roleMapper.roleFromDeleteResponse(role.get());
            }
            return null;
        }
    }

