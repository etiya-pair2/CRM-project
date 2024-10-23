package com.etiya.productservice.dto.campaignProduct;

import lombok.Data;

import java.util.UUID;

@Data
public class GetAllCampaignProductResponse {
    private UUID id;
    private UUID productId;
    private UUID campaignId;
}
