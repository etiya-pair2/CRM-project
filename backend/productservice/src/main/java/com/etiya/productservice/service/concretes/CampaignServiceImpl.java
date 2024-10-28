package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.mapper.CampaignMapper;
import com.etiya.productservice.repository.CampaignRepository;
import com.etiya.productservice.rules.CampaignBusinessRules;
import com.etiya.productservice.service.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;
    private final CampaignBusinessRules campaignBusinessRules;

    CampaignMapper campaignMapper = CampaignMapper.INSTANCE;

    @Override
    public List<GetAllCampaignResponse> getAll() {
        return campaignMapper.campaignFromGetAllResponse(campaignRepository.findAll());
    }

    @Override
    public GetByIdCampaignResponse getById(UUID id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        return campaign.map(value -> campaignMapper.campaignFromGetByIdResponse(value)).orElse(null);
    }

    @Override
    public CreateCampaignResponse create(CreateCampaignRequest request) {
        campaignBusinessRules.validateDiscount(request.getDiscount());
        Campaign campaign = campaignMapper.campaignFromCreateRequest(request);
        campaign.setCreatedDate(new Date());
        campaign.setStatus(true);
        campaignRepository.save(campaign);
        return campaignMapper.campaignFromCreateResponse(campaign);
    }

    @Override
    public UpdateCampaignResponse update(UpdateCampaignRequest request) {
        campaignBusinessRules.checkIfCampaignExists(request.getId());
        campaignBusinessRules.validateDiscount(request.getDiscount());
        Campaign oldCampaign = campaignRepository.findById(request.getId()).orElseThrow();
        Campaign newCampaign = campaignMapper.campaignFromUpdateRequest(request);
        newCampaign.setCreatedDate(oldCampaign.getCreatedDate());
        campaignRepository.save(newCampaign);
        return campaignMapper.campaignFromUpdateResponse(newCampaign);
    }

    @Override
    public DeleteCampaignResponse delete(UUID id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if(campaign.isPresent()) {
            campaignRepository.delete(campaign.get());
            return campaignMapper.campaignFromDeleteResponse(campaign.get());
        }
        else {
            throw new RuntimeException("No campaign found to be deleted: " + id);
        }
    }


}
