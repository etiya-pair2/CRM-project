package com.etiya.orderservice.service.abstracts;

import com.etiya.orderservice.dto.order.*;

import java.util.List;
import java.util.UUID;

public interface OrderService
{
    List<GetAllOrderResponse> getAll();
    CreateOrderResponse create(CreateOrderRequest request);
    UpdateOrderResponse update(UpdateOrderRequest request);
    DeleteOrderResponse delete(UUID id);
    GetByIdOrderResponse getById(UUID id);
}