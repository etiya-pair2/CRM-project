package com.etiya.productservice.dto.product;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateProductRequest {
    private UUID categoryId;
    private String name;
    private double unitPrice;
    private int quantity;

}
