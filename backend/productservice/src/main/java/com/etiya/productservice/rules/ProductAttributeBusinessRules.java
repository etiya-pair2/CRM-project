package com.etiya.productservice.rules;

import com.etiya.productservice.repository.AttributeRepository;
import com.etiya.productservice.repository.ProductAttributeRepository;
import com.etiya.productservice.repository.ProductRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@RequiredArgsConstructor
@Component
public class ProductAttributeBusinessRules {
    private final ProductAttributeRepository productAttributeRepository;
    private final ProductRepository productRepository;
    private final AttributeRepository attributeRepository;

    public void checkIfProductAttributeExist(UUID id) {
        if (!productAttributeRepository.existsById(id)) {
            throw new BusinessException("Product attribute not found.");
        }
    }
    public void checkIfProductExist(UUID id) {
        if (!productRepository.existsById(id)) {
            throw new BusinessException("Product not found.");
        }
    }

    public void checkIfAttributeExist(UUID id) {
        if (!attributeRepository.existsById(id)) {
            throw new BusinessException("Attribute not found.");
        }
    }
}
