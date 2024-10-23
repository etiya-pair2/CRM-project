package com.etiya.customerservice.dto.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeleteAddressResponse {
    private UUID id;
    private UUID customerId;
    private UUID districtId;
    private Boolean accountStatus;
}
