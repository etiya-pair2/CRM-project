package com.etiya.identityservice.mapper;

import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    List<GetAllUserResponse> userFromGetAllResponse(List<User> users);

    GetByIdUserResponse userFromGetByIdResponse(User user);

    @Mapping(source="email",target="email")
    User userFromCreateRequest(CreateUserRequest request);

    CreateUserResponse userFromCreateResponse(User user);

    User userFromUpdateRequest(UpdateUserRequest request);

    UpdateUserResponse userFromUpdateResponse(User user);

    DeleteUserResponse userFromDeleteResponse(User user);
}