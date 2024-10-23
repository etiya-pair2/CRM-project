package com.etiya.identityservice.dto.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateRoleResponse {
    private UUID id;
    private String name;
    private Date createDate;

}
