package com.etiya.identityservice.service.abstracts;

import com.etiya.identityservice.dto.UserRole.*;


import java.util.List;
import java.util.UUID;

public interface UserRoleService {

    List<GetAllUserRoleResponse> getAll();

    GetByIdUserRoleResponse getById(UUID id);

    CreateUserRoleResponse create(CreateUserRoleRequest request);

    UpdateUserRoleResponse update(UpdateUserRoleRequest request);

    DeleteUserRoleResponse delete(UUID id);
}
