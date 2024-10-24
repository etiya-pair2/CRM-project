package com.etiya.identityservice.mapper;
import com.etiya.identityservice.dto.UserRole.*;
import com.etiya.identityservice.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;


@Mapper
public interface UserRoleMapper {

    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roleId", target = "role.id")
    UserRole userRoleFromCreateRequest(CreateUserRoleRequest request);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    CreateUserRoleResponse userRoleFromCreateResponse(UserRole userRole);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roleId", target = "role.id")
    UserRole userRoleFromUpdateRequest(UpdateUserRoleRequest request);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    UpdateUserRoleResponse userRoleFromUpdateResponse(UserRole userRole);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    GetAllUserRoleResponse userRoleFromGetAllResponse(UserRole userRoles);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "role.id", target = "roleId")
    GetByIdUserRoleResponse userRoleFromGetByIdResponse(UserRole userRole);

    DeleteUserRoleResponse userRoleFromDeleteResponse(UserRole userRole);
}