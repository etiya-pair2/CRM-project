package com.etiya.orderservice.service.abstracts;

import com.etiya.orderservice.dto.billingAccountProduct.*;

import java.util.List;
import java.util.UUID;

public interface BillingAccountProductService {
    List<GetAllBillingAccountProductResponse> getAll();
    CreateBillingAccountProductResponse create(CreateBillingAccountProductRequest request);
    UpdateBillingAccountProductResponse update(UpdateBillingAccountProductRequest request);
    DeleteBillingAccountProductResponse delete(UUID id);
    GetByIdBillingAccountProductResponse getById(UUID id);

}
