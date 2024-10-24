package com.etiya.identityservice.mapper.concretes;

import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.entity.User;
import com.etiya.identityservice.mapper.UserMapper;

import java.util.List;

public class UserRoleMapper implements UserMapper {
    @Override
    public List<GetAllUserResponse> userFromGetAllResponse(List<User> users) {
        return List.of();
    }

    @Override
    public GetByIdUserResponse userFromGetByIdResponse(User user) {
        return null;
    }

    @Override
    public User userFromCreateRequest(CreateUserRequest request) {
        return null;
    }

    @Override
    public CreateUserResponse userFromCreateResponse(User user) {
        return null;
    }

    @Override
    public User userFromUpdateRequest(UpdateUserRequest request) {
        return null;
    }

    @Override
    public UpdateUserResponse userFromUpdateResponse(User user) {
        return null;
    }

    @Override
    public DeleteUserResponse userFromDeleteResponse(User user) {
        return null;
    }
}
