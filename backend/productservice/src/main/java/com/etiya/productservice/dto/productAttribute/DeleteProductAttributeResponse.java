package com.etiya.productservice.dto.productAttribute;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteProductAttributeResponse {
    private UUID id;
    private String value;
}
