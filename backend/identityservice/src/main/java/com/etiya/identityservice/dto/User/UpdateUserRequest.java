package com.etiya.identityservice.dto.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private UUID id;

    @NotBlank
    @Size(min = 3, message = "Name must be at least 3 characters long.")
    private String name;

    @NotBlank
    @Size(min = 2, message = "Surname must be at least 2 characters long.")
    private String surname;

    @NotBlank
    @Size(min = 11, max = 11, message = "Identity number must be 11 digits long.")
    @Pattern(regexp = "^[0-9]{11}$", message = "Identity number must contain only digits.")
    private String identityNo;

    @NotBlank
    @Size(min = 8, max = 16)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", message = "The password must contain at least one lowercase letter, one uppercase letter and one number.")
    private String password;

    @NotBlank
    @Size(max = 254)
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+\\.[a-zA-Z0-9.-]+@etiya\\.com$",
            message = "Email must be in the format name.surname@etiya.com"
    )
    private String email;

    @Pattern(
            regexp = "^\\+?\\d+$",
            message = "Phone number must optionally start with '+' and must contain digits only."
    )
    private String phone;

    private Boolean status;
}
