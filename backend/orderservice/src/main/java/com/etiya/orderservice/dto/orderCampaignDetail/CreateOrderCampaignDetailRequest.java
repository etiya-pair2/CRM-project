package com.etiya.orderservice.dto.orderCampaignDetail;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderCampaignDetailRequest {
    private UUID campaignProductsId;
    private int quantity;
    private double unitPrice;
    private double discount;
}