package com.etiya.orderservice.service.abstracts;

import com.etiya.orderservice.dto.orderCampaignDetail.*;

import java.util.List;
import java.util.UUID;

public interface OrderCampaignDetailService {
    List<GetAllOrderCampaignDetailResponse> getAll();
    CreateOrderCampaignDetailResponse create(CreateOrderCampaignDetailRequest request);
    UpdateOrderCampaignDetailResponse update(UpdateOrderCampaignDetailRequest request);
    DeleteOrderCampaignDetailResponse delete(UUID id);
    GetByIdOrderCampaignDetailResponse getById(UUID id);

}
