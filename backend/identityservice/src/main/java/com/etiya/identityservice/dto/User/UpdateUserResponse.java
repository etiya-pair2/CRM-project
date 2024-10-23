package com.etiya.identityservice.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserResponse {
    private String name;
    private String surname;
    private String identityNo;
    private String email;
    private String phone;
}
