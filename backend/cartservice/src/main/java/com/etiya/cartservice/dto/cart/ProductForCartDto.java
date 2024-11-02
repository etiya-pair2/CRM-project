package com.etiya.cartservice.dto.cart;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductForCartDto {
    private UUID productId;
    private int quantity;
}
