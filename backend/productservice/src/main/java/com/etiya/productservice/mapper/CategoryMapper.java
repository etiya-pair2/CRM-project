package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.category.*;
import com.etiya.productservice.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category categoryFromCreateRequest(CreateCategoryRequest dto);

    CreateCategoryResponse categoryFromCreateResponse (Category category);

    Category categoryFromUpdateRequest(UpdateCategoryRequest request);

    UpdateCategoryResponse categoryFromUpdateResponse(Category category);

    List<GetAllCategoryResponse> categoryFromGetAllResponse(List<Category> categories);

    GetByIdCategoryResponse categoryFromGetByIdResponse(Category category);

    DeleteCategoryResponse categoryFromDeleteResponse(Category category);

}
