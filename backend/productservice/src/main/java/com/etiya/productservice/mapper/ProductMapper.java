package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.product.*;
import com.etiya.productservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source="categoryId", target = "category.id")
    Product productFromCreateRequest(CreateProductRequest dto);

    @Mapping(source="category.id", target = "categoryId")
    CreateProductResponse productFromCreateResponse (Product product);

    @Mapping(source="categoryId", target = "category.id")
    Product productFromUpdateRequest(UpdateProductRequest request);

    @Mapping(source="category.id", target = "categoryId")
    UpdateProductResponse productFromUpdateResponse(Product product);

    @Mapping(source="category.id", target = "categoryId")
    List<GetAllProductResponse> productFromGetAllResponse(List<Product> products);

    @Mapping(source = "category.id",target = "categoryId")
    GetByIdProductResponse productFromGetByIdResponse(Product product);

    DeleteProductResponse productFromDeleteResponse(Product product);
}
