package com.etiya.identityservice.mapper;

import com.etiya.identityservice.dto.Role.*;
import com.etiya.identityservice.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    List<GetAllRoleResponse> roleFromGetAllResponse(List<Role> roles);

    GetByIdRoleResponse roleFromGetByIdResponse(Role role);

    Role roleFromCreateRequest(CreateRoleRequest request);

    CreateRoleResponse roleFromCreateResponse(Role role);

    Role roleFromUpdateRequest(UpdateRoleRequest request);

    UpdateRoleResponse roleFromUpdateResponse(Role role);

    DeleteRoleResponse roleFromDeleteResponse(Role role);
}
