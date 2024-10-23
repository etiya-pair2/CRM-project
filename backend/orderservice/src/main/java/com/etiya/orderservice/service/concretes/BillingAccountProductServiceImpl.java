package com.etiya.orderservice.service.concretes;

import com.etiya.orderservice.dto.billingAccountProduct.*;
import com.etiya.orderservice.entity.BillingAccountProduct;
import com.etiya.orderservice.mapper.BillingAccountProductMapper;
import com.etiya.orderservice.repository.BillingAccountProductRepository;
import com.etiya.orderservice.service.abstracts.BillingAccountProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BillingAccountProductServiceImpl implements BillingAccountProductService {
    private final BillingAccountProductRepository billingAccountProductRepository;
    BillingAccountProductMapper billingAccountProductMapper = BillingAccountProductMapper.INSTANCE;

    @Override
    public List<GetAllBillingAccountProductResponse> getAll() {
        return billingAccountProductMapper.billingAccountProductFromGetAllResponse(billingAccountProductRepository.findAll());
    }

    @Override
    public CreateBillingAccountProductResponse create(CreateBillingAccountProductRequest request) {
        BillingAccountProduct billingAccountProduct = billingAccountProductRepository.save(billingAccountProductMapper.billingAccountProductFromCreateRequest(request));
        return billingAccountProductMapper.billingAccountProductFromCreateResponse(billingAccountProduct);
    }

    @Override
    public UpdateBillingAccountProductResponse update(UpdateBillingAccountProductRequest request) {
        BillingAccountProduct billingAccountProduct = billingAccountProductRepository.save(
                billingAccountProductMapper.billingAccountProductFromUpdateRequest(request)
        );
        return billingAccountProductMapper.billingAccountProductFromUpdateResponse(billingAccountProduct);
    }

    @Override
    public DeleteBillingAccountProductResponse delete(UUID id) {
        BillingAccountProduct billingAccountProduct = billingAccountProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BillingAccountProduct not found."));
        billingAccountProductRepository.deleteById(id);
        return billingAccountProductMapper.billingAccountProductFromDeleteResponse(billingAccountProduct);
    }

    @Override
    public GetByIdBillingAccountProductResponse getById(UUID id) {
        return billingAccountProductRepository.findById(id)
                .map(billingAccountProductMapper::billingAccountProductFromGetByIdResponse)
                .orElseThrow(() -> new RuntimeException("BillingAccountProduct not found with ID: " + id));
    }

}
