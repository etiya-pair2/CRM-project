package com.etiya.cartservice.dto.cart;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartResponse {
    private UUID id;
    private UUID customerId;
    private Date updateDate;
}
