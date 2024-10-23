package com.etiya.productservice.dto.attribute;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateAttributeResponse {
    private UUID id;
    private String name;
}
