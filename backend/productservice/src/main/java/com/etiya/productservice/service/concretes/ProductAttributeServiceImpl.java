package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.productAttribute.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.entity.ProductAttribute;
import com.etiya.productservice.mapper.AttributeMapper;
import com.etiya.productservice.mapper.ProductAttributeMapper;
import com.etiya.productservice.repository.ProductAttributeRepository;
import com.etiya.productservice.service.abstracts.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;

    ProductAttributeMapper productAttributeMapper = ProductAttributeMapper.INSTANCE;

    @Override
    public List<GetAllProductAttributeResponse> getAll() {
        return productAttributeMapper.productAttributeFromGetAllResponse(productAttributeRepository.findAll());
    }

    @Override
    public GetByIdProductAttributeResponse getById(UUID id) {
        Optional<ProductAttribute> attribute = productAttributeRepository.findById(id);
        return attribute.map(value -> productAttributeMapper.productAttributeFromGetByIdResponse(value)).orElse(null);
    }

    @Override
    public CreateProductAttributeResponse create(CreateProductAttributeRequest request) {
        ProductAttribute productAttribute = productAttributeMapper.productAttributeFromCreateRequest(request);
        return productAttributeMapper.productAttributeFromCreateResponse(productAttribute);
    }

    @Override
    public UpdateProductAttributeResponse update(UpdateProductAttributeRequest request) {
        ProductAttribute productAttribute = productAttributeMapper.productAttributeFromUpdateRequest(request);
        return productAttributeMapper.productAttributeFromUpdateResponse(productAttribute);
    }

    @Override
    public DeleteProductAttributeResponse delete(UUID id) {
        Optional<ProductAttribute> productAttribute  = productAttributeRepository.findById(id);
        productAttribute.ifPresent(productAttributeRepository::delete);
        return productAttributeMapper.productAttributeFromDeleteResponse(productAttribute.get());
    }


}
