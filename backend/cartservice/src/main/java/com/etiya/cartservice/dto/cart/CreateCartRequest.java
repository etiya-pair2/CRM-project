package com.etiya.cartservice.dto.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartRequest {
//    private UUID customerId;
    private Boolean status;
}
