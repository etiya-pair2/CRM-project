package com.etiya.orderservice.service.concretes;

import com.etiya.orderservice.dto.orderCampaignDetail.*;
import com.etiya.orderservice.entity.OrderCampaignDetail;
import com.etiya.orderservice.mapper.OrderCampaignDetailMapper;
import com.etiya.orderservice.repository.OrderCampaignDetailRepository;
import com.etiya.orderservice.service.abstracts.OrderCampaignDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderCampaignDetailServiceImpl implements OrderCampaignDetailService {
    private final OrderCampaignDetailRepository orderCampaignDetailRepository;
    OrderCampaignDetailMapper orderCampaignDetailMapper = OrderCampaignDetailMapper.INSTANCE;

    @Override
    public List<GetAllOrderCampaignDetailResponse> getAll() {
        return orderCampaignDetailMapper.orderCampaignDetailFromGetAllResponse(orderCampaignDetailRepository.findAll());
    }

    @Override
    public CreateOrderCampaignDetailResponse create(CreateOrderCampaignDetailRequest request) {
        OrderCampaignDetail orderCampaignDetail = orderCampaignDetailRepository.save(orderCampaignDetailMapper.orderCampaignDetailFromCreateRequest(request));
        return orderCampaignDetailMapper.orderCampaignDetailFromCreateResponse(orderCampaignDetail);
    }

    @Override
    public UpdateOrderCampaignDetailResponse update(UpdateOrderCampaignDetailRequest request) {
        OrderCampaignDetail orderCampaignDetail = orderCampaignDetailRepository.save(orderCampaignDetailMapper.orderCampaignDetailFromUpdateRequest(request));
        return orderCampaignDetailMapper.orderCampaignDetailFromUpdateResponse(orderCampaignDetail);
    }

    @Override
    public DeleteOrderCampaignDetailResponse delete(UUID id) {
        OrderCampaignDetail orderCampaignDetail = orderCampaignDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderCampaignDetail not found"));
        orderCampaignDetailRepository.deleteById(id);
        return orderCampaignDetailMapper.orderCampaignDetailFromDeleteResponse(orderCampaignDetail);
    }


    @Override
    public GetByIdOrderCampaignDetailResponse getById(UUID id) {
        return orderCampaignDetailRepository.findById(id)
                .map(orderCampaignDetailMapper::orderCampaignDetailFromGetByIdResponse)
                .orElseThrow(() -> new RuntimeException("OrderCampaignDetail not found with ID: " + id));
    }
}
