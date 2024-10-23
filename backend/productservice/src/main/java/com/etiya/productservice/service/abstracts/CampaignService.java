package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.dto.campaignProduct.*;

import java.util.List;
import java.util.UUID;

public interface CampaignService {

    List<GetAllCampaignResponse> getAll();
    CreateCampaignResponse create(CreateCampaignRequest request);
    UpdateCampaignResponse update(UpdateCampaignRequest request);
    DeleteCampaignResponse delete(UUID id);
    GetByIdCampaignResponse getById(UUID id);
}
