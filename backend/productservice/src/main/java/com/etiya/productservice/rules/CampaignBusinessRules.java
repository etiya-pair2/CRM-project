package com.etiya.productservice.rules;

import com.etiya.productservice.repository.CampaignRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CampaignBusinessRules {

    private final CampaignRepository campaignRepository;

    public void checkIfCampaignExists(UUID id) {
        if (!campaignRepository.existsById(id)) {
            throw new BusinessException("Campaign not found.");
        }
    }

    public void validateDiscount(double discount) {
        if (discount < 0) {
            throw new BusinessException("Discount cannot be negative.");
        }
        if (discount > 100) {
            throw new BusinessException("Discount cannot exceed 100%.");
        }
    }

}
