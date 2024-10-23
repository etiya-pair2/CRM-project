package com.etiya.identityservice.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoleRequest {
    private UUID id;
    private String name;
    private Boolean status;
}
