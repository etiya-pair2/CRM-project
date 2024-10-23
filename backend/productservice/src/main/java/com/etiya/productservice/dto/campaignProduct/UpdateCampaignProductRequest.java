package com.etiya.productservice.dto.campaignProduct;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateCampaignProductRequest {
    private UUID id;
    private UUID productId;
    private UUID campaignId;
}
