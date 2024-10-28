package com.etiya.productservice.dto.category;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCategoryRequest {

    @Size(min = 2, max = 30, message = "Category name must be between 2 and 30 characters")
    private String name;
}
