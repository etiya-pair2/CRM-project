package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.productAttribute.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.entity.ProductAttribute;
import com.etiya.productservice.mapper.ProductAttributeMapper;
import com.etiya.productservice.repository.ProductAttributeRepository;
import com.etiya.productservice.rules.ProductAttributeBusinessRules;
import com.etiya.productservice.service.abstracts.ProductAttributeService;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductAttributeServiceImpl implements ProductAttributeService {

    private final ProductAttributeRepository productAttributeRepository;
    private final ProductAttributeBusinessRules productAttributeBusinessRules;
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
        productAttributeBusinessRules.checkIfAttributeExist(request.getAttributeId());
        productAttributeBusinessRules.checkIfProductExist(request.getProductId());
        ProductAttribute productAttribute = productAttributeRepository.save(productAttributeMapper.productAttributeFromCreateRequest(request));
        return productAttributeMapper.productAttributeFromCreateResponse(productAttribute);
    }

    @Override
    public UpdateProductAttributeResponse update(UpdateProductAttributeRequest request) {
        productAttributeBusinessRules.checkIfProductAttributeExist(request.getId());
        productAttributeBusinessRules.checkIfProductExist(request.getProductId());
        productAttributeBusinessRules.checkIfAttributeExist(request.getAttributeId());
        ProductAttribute productAttribute = productAttributeRepository.save(productAttributeMapper.productAttributeFromUpdateRequest(request));
        return productAttributeMapper.productAttributeFromUpdateResponse(productAttribute);
    }

    @Override
    public DeleteProductAttributeResponse delete(UUID id) {
        Optional<ProductAttribute> productAttribute  = productAttributeRepository
                .findById(id);
        if (productAttribute.isPresent()) {
            productAttributeRepository.delete(productAttribute.get());
            return productAttributeMapper.productAttributeFromDeleteResponse(productAttribute.get());
        } else {
            throw new BusinessException("ProductAttribute with ID " + id + " does not exist.");
        }
    }

}
