package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.productAttribute.*;

import java.util.List;
import java.util.UUID;

public interface ProductAttributeService {

    List<GetAllProductAttributeResponse> getAll();
    CreateProductAttributeResponse create(CreateProductAttributeRequest request);
    UpdateProductAttributeResponse update(UpdateProductAttributeRequest request);
    DeleteProductAttributeResponse delete(UUID id);
    GetByIdProductAttributeResponse getById(UUID id);
}
