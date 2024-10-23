package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.campaignProduct.*;

import java.util.List;
import java.util.UUID;

public interface CampaignProductService {
    List<GetAllCampaignProductResponse> getAll();
    CreateCampaignProductResponse create(CreateCampaignProductRequest request);
    UpdateCampaignProductResponse update(UpdateCampaignProductRequest request);
    DeleteCampaignProductResponse delete(UUID id);
    GetByIdCampaignProductResponse getById(UUID id);
}
