package com.etiya.identityservice.dto.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String name;
    private String surname;
    private String identityNo;
    private String password;
    private String email;
    private String phone;
    private Boolean status;
//  private List<UUID> roleIds;


}