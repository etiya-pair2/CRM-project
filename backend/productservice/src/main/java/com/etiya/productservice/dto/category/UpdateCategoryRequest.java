package com.etiya.productservice.dto.category;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;
@Data
public class UpdateCategoryRequest {
    private UUID id;

    @Size(min = 2, max = 30, message = "Category name must be between 2 and 30 characters")
    private String name;
}
