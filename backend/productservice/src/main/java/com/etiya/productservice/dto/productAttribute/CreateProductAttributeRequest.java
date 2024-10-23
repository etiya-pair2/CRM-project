package com.etiya.productservice.dto.productAttribute;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateProductAttributeRequest {
    private UUID productId;
    private UUID attributeId;
    private String value;
}
