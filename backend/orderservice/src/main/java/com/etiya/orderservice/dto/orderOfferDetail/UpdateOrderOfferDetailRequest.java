package com.etiya.orderservice.dto.orderOfferDetail;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderOfferDetailRequest {
    private UUID id;
    private UUID offerProductsId;
    private int quantity;
    private double unitPrice;
    private double discount;
}

