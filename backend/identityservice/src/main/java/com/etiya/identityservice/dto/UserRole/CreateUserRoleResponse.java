package com.etiya.identityservice.dto.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRoleResponse {
    private UUID id;
    private UUID userId;
    private UUID roleId;
    private Boolean status;
    private Date createDate;
}
