package com.etiya.productservice.dto.category;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteCategoryResponse {
    private UUID id;
    private String name;
}
