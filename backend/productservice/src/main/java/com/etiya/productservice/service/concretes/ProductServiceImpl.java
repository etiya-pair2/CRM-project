package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.product.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.entity.Campaign;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.mapper.ProductMapper;
import com.etiya.productservice.repository.ProductRepository;
import com.etiya.productservice.rules.ProductBusinessRules;
import com.etiya.productservice.service.abstracts.ProductService;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductBusinessRules productBusinessRules;
    ProductMapper productMapper = ProductMapper.INSTANCE;

    @Override
    public List<Product> search(List<UUID> ids) {
        return productRepository.findByIdIn(ids);
    }

    @Override
    public List<GetAllProductResponse> getAll() {

        return productMapper.productFromGetAllResponse(productRepository.findAll());

    }

    @Override
    public GetByIdProductResponse getById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(value -> productMapper.productFromGetByIdResponse(value)).orElse(null);
    }

    @Override
    public CreateProductResponse create(CreateProductRequest request) {
        productBusinessRules.checkIfCategoryExists(request.getCategoryId());
        Product product = productRepository.save(productMapper.productFromCreateRequest(request));
        return productMapper.productFromCreateResponse(product);
    }

    @Override
    public UpdateProductResponse update(UpdateProductRequest request) {
        productBusinessRules.checkIfProductExist(request.getId());
        productBusinessRules.checkIfCategoryExists(request.getCategoryId());
        Product product = productRepository.save(productMapper.productFromUpdateRequest(request));
        return productMapper.productFromUpdateResponse(product);
    }

    @Override
    public DeleteProductResponse delete(UUID id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            productRepository.deleteById(id);
            return productMapper.productFromDeleteResponse(product.get());
        } else {
            throw new BusinessException("Product with ID " + id + " does not exist.");
        }
    }

}