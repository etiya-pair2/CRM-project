package com.etiya.customerservice.dto.contactMedium;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateContactMediumRequest {

    @NotNull
    private UUID customerId;

    @NotBlank
    @Size(max = 254)
    @Pattern(
            regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "Geçerli bir e-posta adresi giriniz"
    )
    private String email;

    @Size(min = 11, max = 11, message = "Ev telefonu 11 haneli olmalıdır")
    private String homePhone;

    @NotBlank(message = "Mobil telefon boş bırakılamaz")
    @Size(min = 11, max = 11, message = "Mobil telefon 11 haneli olmalıdır")
    private String mobilePhone;

    @Size(min = 11, max = 11, message = "Faks 11 haneli olmalıdır")
    @Pattern(regexp = "^0\\d{10}$", message = "Faks 0 ile başlamalıdır")
    private String fax;

}
