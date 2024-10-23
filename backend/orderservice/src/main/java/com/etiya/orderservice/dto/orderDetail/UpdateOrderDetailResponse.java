package com.etiya.orderservice.dto.orderDetail;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderDetailResponse {
    private UUID id;
    private UUID productId;
    private int quantity;
    private double unitPrice;
    private double discount;
}
