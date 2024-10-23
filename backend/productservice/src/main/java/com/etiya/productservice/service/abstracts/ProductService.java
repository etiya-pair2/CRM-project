package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.dto.product.*;
import com.etiya.productservice.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> search(List<UUID> ids);

    List<GetAllProductResponse> getAll();
    CreateProductResponse create(CreateProductRequest request);
    UpdateProductResponse update(UpdateProductRequest request);
    DeleteProductResponse delete(UUID id);

    GetByIdProductResponse getById(UUID id);
}