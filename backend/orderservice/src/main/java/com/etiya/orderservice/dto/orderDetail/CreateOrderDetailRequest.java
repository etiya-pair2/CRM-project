package com.etiya.orderservice.dto.orderDetail;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderDetailRequest {
    private UUID productId;
    private int quantity;
    private double unitPrice;
    private double discount;
}
