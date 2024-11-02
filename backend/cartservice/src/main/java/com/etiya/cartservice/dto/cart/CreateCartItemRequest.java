package com.etiya.cartservice.dto.cart;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class CreateCartItemRequest {
    private UUID customerId;
    private ProductForCartDto product;
}
