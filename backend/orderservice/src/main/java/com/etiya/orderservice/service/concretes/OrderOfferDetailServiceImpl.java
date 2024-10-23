package com.etiya.orderservice.service.concretes;

import com.etiya.orderservice.dto.orderOfferDetail.*;
import com.etiya.orderservice.entity.OrderOfferDetail;
import com.etiya.orderservice.mapper.OrderOfferDetailMapper;
import com.etiya.orderservice.repository.OrderOfferDetailRepository;
import com.etiya.orderservice.service.abstracts.OrderOfferDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderOfferDetailServiceImpl implements OrderOfferDetailService {
    private final OrderOfferDetailRepository orderOfferDetailRepository;
    OrderOfferDetailMapper orderOfferDetailMapper = OrderOfferDetailMapper.INSTANCE;

    @Override
    public List<GetAllOrderOfferDetailResponse> getAll() {
        return orderOfferDetailMapper.orderOfferDetailFromGetAllResponse(orderOfferDetailRepository.findAll());
    }

    @Override
    public CreateOrderOfferDetailResponse create(CreateOrderOfferDetailRequest request) {
        OrderOfferDetail orderOfferDetail = orderOfferDetailRepository.save(orderOfferDetailMapper.orderOfferDetailFromCreateRequest(request));
        return orderOfferDetailMapper.orderOfferDetailFromCreateResponse(orderOfferDetail);
    }

    @Override
    public UpdateOrderOfferDetailResponse update(UpdateOrderOfferDetailRequest request) {
        OrderOfferDetail orderOfferDetail = orderOfferDetailRepository.save(orderOfferDetailMapper.orderOfferDetailFromUpdateRequest(request));
        return orderOfferDetailMapper.orderOfferDetailFromUpdateResponse(orderOfferDetail);
    }

    @Override
    public DeleteOrderOfferDetailResponse delete(UUID id) {
        OrderOfferDetail orderOfferDetail = orderOfferDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order Offer Detail not found: " + id));
        orderOfferDetailRepository.deleteById(id);
        return orderOfferDetailMapper.orderOfferDetailFromDeleteResponse(orderOfferDetail);
    }


    @Override
    public GetByIdOrderOfferDetailResponse getById(UUID id) {
        return orderOfferDetailRepository.findById(id)
            .map(orderOfferDetailMapper::orderOfferDetailFromGetByIdResponse)
                .orElseThrow(() -> new RuntimeException("OrderOfferDetail not found with ID: " + id));
}
}
