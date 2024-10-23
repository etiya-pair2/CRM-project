package com.etiya.orderservice.service.abstracts;

import com.etiya.orderservice.dto.orderOfferDetail.*;

import java.util.List;
import java.util.UUID;

public interface OrderOfferDetailService {
    List<GetAllOrderOfferDetailResponse> getAll();
    CreateOrderOfferDetailResponse create(CreateOrderOfferDetailRequest request);
    UpdateOrderOfferDetailResponse update(UpdateOrderOfferDetailRequest request);
    DeleteOrderOfferDetailResponse delete(UUID id);
    GetByIdOrderOfferDetailResponse getById(UUID id);

}
