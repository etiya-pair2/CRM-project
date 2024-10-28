package com.etiya.productservice.dto.product;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.UUID;

@Data
public class CreateProductRequest {
    private UUID categoryId;

    @Size(min = 2, max = 30, message = "Product name must be between 2 and 30 characters")
    private String name;
    private double unitPrice;

    @Min(value = 1, message = "Quantity must be at least 1")
    @Max(value = 100, message = "Quantity must not exceed 100")
    private int quantity;

}
