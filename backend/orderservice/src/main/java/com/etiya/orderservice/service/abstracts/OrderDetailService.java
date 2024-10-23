package com.etiya.orderservice.service.abstracts;

import com.etiya.orderservice.dto.orderDetail.*;

import java.util.List;
import java.util.UUID;

public interface OrderDetailService {
    List<GetAllOrderDetailResponse> getAll();
    CreateOrderDetailResponse create(CreateOrderDetailRequest request);
    UpdateOrderDetailResponse update(UpdateOrderDetailRequest request);
    DeleteOrderDetailResponse delete(UUID id);
    GetByIdOrderDetailResponse getById(UUID id);

}
