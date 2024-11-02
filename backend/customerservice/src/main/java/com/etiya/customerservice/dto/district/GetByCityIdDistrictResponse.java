package com.etiya.customerservice.dto.district;

import lombok.Data;

import java.util.UUID;

@Data
public class GetByCityIdDistrictResponse {
    private UUID id;
    private String name;
}
