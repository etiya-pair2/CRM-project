package com.etiya.productservice.rules;

import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Category;
import com.etiya.productservice.repository.CategoryRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public void checkIfCategoryExists(UUID id) {
        if (!categoryRepository.existsById(id)) {
            throw new BusinessException("Category not found.");
        }
    }

    public void checkIfNameExist(String name) {
        Optional<Category> categoryOptional = categoryRepository.findByNameIgnoreCase(name);
        if (categoryOptional.isPresent()) {
            throw new BusinessException("Category name already exist");
        }
    }
}
