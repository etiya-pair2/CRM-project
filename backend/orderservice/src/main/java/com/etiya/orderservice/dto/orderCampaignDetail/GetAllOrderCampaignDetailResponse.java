package com.etiya.orderservice.dto.orderCampaignDetail;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderCampaignDetailResponse {
    private UUID id;
    private UUID campaignProductsId;
    private int quantity;
    private double unitPrice;
    private double discount;
}
