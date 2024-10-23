package com.etiya.identityservice.dto.UserRole;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdUserRoleResponse {
    private UUID id;
    private UUID userId; // Kullanıcının ID'si
    private UUID roleId;
    private Date createdDate;
    private Date updatedDate;
    private Boolean status;
}
