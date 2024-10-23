package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Campaign;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignMapper {

    CampaignMapper INSTANCE = Mappers.getMapper(CampaignMapper.class);

    Campaign campaignFromCreateRequest(CreateCampaignRequest request);

    CreateCampaignResponse campaignFromCreateResponse (Campaign campaign);

    Campaign campaignFromUpdateRequest(UpdateCampaignRequest request);

    UpdateCampaignResponse campaignFromUpdateResponse(Campaign campaign);

    List<GetAllCampaignResponse> campaignFromGetAllResponse(List<Campaign> campaigns);

    GetByIdCampaignResponse campaignFromGetByIdResponse(Campaign campaign);

    DeleteCampaignResponse campaignFromDeleteResponse(Campaign campaign);

}
