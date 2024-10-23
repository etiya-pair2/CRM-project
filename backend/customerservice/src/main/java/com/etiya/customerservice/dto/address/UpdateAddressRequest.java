package com.etiya.customerservice.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAddressRequest {
    private UUID id;
    private UUID customerId;
    private UUID districtId;
    @NotNull
    @NotBlank
    private String postalCode;
    private String description;
    @NotNull
    @NotBlank
    private String flatNumber;
}
