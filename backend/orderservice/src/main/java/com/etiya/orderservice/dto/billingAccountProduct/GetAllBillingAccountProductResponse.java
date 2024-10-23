package com.etiya.orderservice.dto.billingAccountProduct;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBillingAccountProductResponse {
    private UUID id;
    private UUID orderId;
    private UUID billingAccountId;
    private UUID productId;
}