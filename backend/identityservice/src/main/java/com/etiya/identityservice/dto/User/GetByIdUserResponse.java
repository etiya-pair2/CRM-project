package com.etiya.identityservice.dto.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdUserResponse {
    private UUID id;
    private  String name;
    private String surname;
    private String email;
    private String phone;
}
