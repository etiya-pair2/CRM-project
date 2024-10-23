package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.campaignProduct.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.CampaignProduct;
import com.etiya.productservice.mapper.CampaignProductMapper;
import com.etiya.productservice.repository.CampaignProductRepository;
import com.etiya.productservice.service.abstracts.CampaignProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampaignProductServiceImpl implements CampaignProductService {

    private final CampaignProductRepository campaignProductRepository;

    CampaignProductMapper campaignProductMapper = CampaignProductMapper.INSTANCE;
    @Override
    public List<GetAllCampaignProductResponse> getAll() {
        return campaignProductMapper.campaignProductFromGetAllResponse(campaignProductRepository.findAll());
    }

    @Override
    public GetByIdCampaignProductResponse getById(UUID id) {
        Optional<CampaignProduct> campaignProduct = campaignProductRepository.findById(id);
        return campaignProduct.map(value -> campaignProductMapper.campaignProductFromGetByIdResponse(value)).orElse(null);
    }

    @Override
    public CreateCampaignProductResponse create(CreateCampaignProductRequest request) {
        CampaignProduct campaignProduct =  campaignProductRepository.save(campaignProductMapper.campaignProductFromCreateRequest(request));
        return campaignProductMapper.campaignProductFromCreateResponse(campaignProduct);
    }

    @Override
    public UpdateCampaignProductResponse update(UpdateCampaignProductRequest request) {
        CampaignProduct campaignProduct =  campaignProductRepository.save(campaignProductMapper.campaignProductFromUpdateRequest(request));
        return campaignProductMapper.campaignProductFromUpdateResponse(campaignProduct);
    }

    @Override
    public DeleteCampaignProductResponse delete(UUID id) {
        campaignProductRepository.deleteById(id);
        return campaignProductMapper.campaignProductFromDeleteResponse(campaignProductRepository.findById(id).orElseThrow());
    }


}
