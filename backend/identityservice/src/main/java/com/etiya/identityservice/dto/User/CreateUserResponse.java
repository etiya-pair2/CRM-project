package com.etiya.identityservice.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserResponse {
    private UUID id;
    private String name;
    private String surname;
    private String identityNo;
    private String password;
    private String email;
    private Date createDate;


}