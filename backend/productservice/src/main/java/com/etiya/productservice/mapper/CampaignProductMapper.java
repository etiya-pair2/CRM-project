package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.campaign.CreateCampaignRequest;
import com.etiya.productservice.dto.campaignProduct.*;
import com.etiya.productservice.dto.category.*;
import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CampaignProductMapper {

    CampaignProductMapper INSTANCE = Mappers.getMapper(CampaignProductMapper.class);

    @Mapping(source="productId", target = "product.id")
    @Mapping(source="campaignId", target = "campaign.id")
    CampaignProduct campaignProductFromCreateRequest(CreateCampaignProductRequest request);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="campaign.id", target = "campaignId")
    CreateCampaignProductResponse campaignProductFromCreateResponse (CampaignProduct campaignProduct);

    @Mapping(source="productId", target = "product.id")
    @Mapping(source="campaignId", target = "campaign.id")
    CampaignProduct campaignProductFromUpdateRequest(UpdateCampaignProductRequest request);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="campaign.id", target = "campaignId")
    UpdateCampaignProductResponse campaignProductFromUpdateResponse(CampaignProduct campaignProduct);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="campaign.id", target = "campaignId")
    List<GetAllCampaignProductResponse> campaignProductFromGetAllResponse(List<CampaignProduct> campaignProducts);

    @Mapping(source="product.id", target = "productId")
    @Mapping(source="campaign.id", target = "campaignId")
    GetByIdCampaignProductResponse campaignProductFromGetByIdResponse(CampaignProduct campaignProduct);

    DeleteCampaignProductResponse campaignProductFromDeleteResponse(CampaignProduct campaignProduct);
}
