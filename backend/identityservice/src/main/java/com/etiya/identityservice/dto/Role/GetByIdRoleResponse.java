package com.etiya.identityservice.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdRoleResponse {
    private UUID id;
    private String name;
    private Date createdDate;
    private Date updatedDate;
    private Boolean status;
}
