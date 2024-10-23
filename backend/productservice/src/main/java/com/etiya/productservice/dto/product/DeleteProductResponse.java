package com.etiya.productservice.dto.product;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteProductResponse {
    private UUID id;
    private String name;
}
