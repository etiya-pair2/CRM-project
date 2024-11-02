package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.category.*;
import com.etiya.productservice.entity.Category;
import com.etiya.productservice.mapper.CategoryMapper;
import com.etiya.productservice.repository.CategoryRepository;
import com.etiya.productservice.rules.CategoryBusinessRules;
import com.etiya.productservice.service.abstracts.CategoryService;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryBusinessRules categoryBusinessRules;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;
    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        return categoryMapper.categoryFromGetAllResponse(categories);
    }

    @Override
    public GetByIdCategoryResponse getById(UUID id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(value -> categoryMapper.categoryFromGetByIdResponse(value)).orElse(null);
    }

    @Override
    public CreateCategoryResponse create(CreateCategoryRequest request) {
        categoryBusinessRules.checkIfNameExist(request.getName());
        Category category = categoryRepository.save(categoryMapper.categoryFromCreateRequest(request));
        return categoryMapper.categoryFromCreateResponse(category);
    }

    @Override
    public UpdateCategoryResponse update(UpdateCategoryRequest request) {
        categoryBusinessRules.checkIfCategoryExists(request.getId());
        categoryBusinessRules.checkIfNameExist(request.getName());
        Category category = categoryRepository.save(categoryMapper.categoryFromUpdateRequest(request));
        return categoryMapper.categoryFromUpdateResponse(category);
    }

    // TODO: metodun içeriğini tartış
    @Override
    public DeleteCategoryResponse delete(UUID id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new BusinessException("Category with ID " + id + " does not exist."));
        categoryRepository.delete(category);
        return categoryMapper.categoryFromDeleteResponse(category);
    }

}
