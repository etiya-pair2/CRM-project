package com.etiya.productservice.dto.product;

import lombok.Data;

import java.util.UUID;

@Data
public class GetAllProductResponse {
    private UUID id;
    private UUID categoryId;
    private String name;
    private double unitPrice;
    private int quantity;
}
