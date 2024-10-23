package com.etiya.identityservice.service.abstracts;

import com.etiya.identityservice.dto.Role.*;



import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<GetAllRoleResponse> getAll();
    GetByIdRoleResponse getById(UUID id);
    CreateRoleResponse create(CreateRoleRequest request);
    UpdateRoleResponse update(UpdateRoleRequest request);
    DeleteRoleResponse delete(UUID id);
}
