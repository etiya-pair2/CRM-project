package com.etiya.customerservice.dto.address;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotBlank
    @Positive
    private String postalCode;
    private String description;
    @NotNull
    @NotBlank
    @Positive
    private String flatNumber;
}
