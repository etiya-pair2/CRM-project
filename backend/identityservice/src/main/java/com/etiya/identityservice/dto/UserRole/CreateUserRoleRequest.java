package com.etiya.identityservice.dto.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRoleRequest {

    private UUID userId; // Kullanıcının ID'si
    private UUID roleId; // Rolün ID'si
    private Boolean status;

}
