package com.etiya.productservice.dto.category;

import lombok.Data;

import java.util.UUID;
@Data
public class UpdateCategoryRequest {
    private UUID id;
    private String name;
}
