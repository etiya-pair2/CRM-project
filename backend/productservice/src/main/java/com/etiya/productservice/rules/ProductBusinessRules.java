package com.etiya.productservice.rules;

import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.repository.CategoryRepository;
import com.etiya.productservice.repository.ProductRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductBusinessRules {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public void checkIfProductExist(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new BusinessException("Product can not found.");
        }
    }

    public void checkIfCategoryExists(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new BusinessException("No category found.");
        }
    }
}
