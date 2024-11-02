package com.etiya.customerservice.dto.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAddressRequest {


    private UUID customerId;
    private UUID districtId;

    @NotNull
    @NotBlank(message = "Lütfen Posta Kodu Giriniz")
    @Size(min = 5, max = 5, message = "Posta Kodu 5 haneli olmalıdır")
    @Pattern(regexp = "\\d{5}", message = "Posta Kodu sadece rakamlardan oluşmalıdır")
    private String postalCode;

    @NotNull
    @NotBlank(message = "Lütfen Adres Açıklamasını doldurunuz")
    private String description;

    private String flatNumber;
}
