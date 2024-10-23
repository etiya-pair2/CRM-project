package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.category.*;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();

    GetByIdCategoryResponse getById(UUID id);
    CreateCategoryResponse create(CreateCategoryRequest request);
    UpdateCategoryResponse update(UpdateCategoryRequest request);
    DeleteCategoryResponse delete(UUID id);

}
