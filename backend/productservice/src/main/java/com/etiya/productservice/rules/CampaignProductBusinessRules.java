package com.etiya.productservice.rules;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.repository.CampaignProductRepository;
import com.etiya.productservice.repository.CampaignRepository;
import com.etiya.productservice.repository.ProductRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CampaignProductBusinessRules {
    private final ProductRepository productRepository;
    private final CampaignRepository campaignRepository;
    private final CampaignProductRepository campaignProductRepository;

    public void checkIfProductExist(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new BusinessException("Product can not found.");
        }
    }

    public void checkIfCampaignExist(UUID id) {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if(campaign.isEmpty()){
            throw new BusinessException("Campaign can not found.");
        }
    }

    public void checkIfCampaignProductExists(UUID id) {
        if (!campaignProductRepository.existsById(id)) {
            throw new BusinessException("No campaign product found.");
        }
    }

}
