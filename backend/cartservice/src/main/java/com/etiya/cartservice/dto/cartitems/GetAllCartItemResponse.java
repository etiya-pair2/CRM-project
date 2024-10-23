package com.etiya.cartservice.dto.cartitems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCartItemResponse {
    private UUID id;
    private UUID cartId; // Sepetin ID'si
}
