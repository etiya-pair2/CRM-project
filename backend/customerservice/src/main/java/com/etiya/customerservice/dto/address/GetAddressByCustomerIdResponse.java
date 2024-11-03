package com.etiya.customerservice.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAddressByCustomerIdResponse {
    private UUID id;
    private UUID districtId;
    private String postalCode;
    private String description;
    private String flatNumber;
}
