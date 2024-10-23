package com.etiya.productservice.dto.productAttribute;

import lombok.Data;

import java.util.UUID;

@Data
public class GetAllProductAttributeResponse {
    private UUID id;
    private UUID productId;
    private UUID attributeId;
    private String value;
}
