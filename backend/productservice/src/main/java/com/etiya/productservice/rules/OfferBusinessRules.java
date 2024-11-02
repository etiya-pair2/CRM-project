package com.etiya.productservice.rules;

import com.etiya.productservice.entity.Category;
import com.etiya.productservice.repository.OfferRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class OfferBusinessRules {

    private final OfferRepository offerRepository;
    public void checkIfOfferExists(UUID id) {
        if (!offerRepository.existsById(id)) {
            throw new BusinessException("Offer not found.");
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
