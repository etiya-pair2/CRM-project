package com.etiya.productservice.dto.campaignProduct;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateCampaignProductRequest {
    private UUID productId;
    private UUID campaignId;
}
