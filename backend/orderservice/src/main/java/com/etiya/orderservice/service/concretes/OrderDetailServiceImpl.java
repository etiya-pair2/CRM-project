package com.etiya.orderservice.service.concretes;

import com.etiya.orderservice.dto.orderDetail.*;
import com.etiya.orderservice.entity.OrderDetail;
import com.etiya.orderservice.mapper.OrderDetailMapper;
import com.etiya.orderservice.repository.OrderDetailRepository;
import com.etiya.orderservice.service.abstracts.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;
    OrderDetailMapper orderDetailMapper = OrderDetailMapper.INSTANCE;

    @Override
    public List<GetAllOrderDetailResponse> getAll() {
        return orderDetailMapper.orderDetailFromGetAllResponse(orderDetailRepository.findAll());
    }

    @Override
    public CreateOrderDetailResponse create(CreateOrderDetailRequest request) {
        OrderDetail orderDetail = orderDetailRepository.save(orderDetailMapper.orderDetailFromCreateRequest(request));
        return orderDetailMapper.orderDetailFromCreateResponse(orderDetail);
    }

    @Override
    public UpdateOrderDetailResponse update(UpdateOrderDetailRequest request) {
        OrderDetail orderDetail = orderDetailRepository.save(orderDetailMapper.orderDetailFromUpdateRequest(request));
        return orderDetailMapper.orderDetailFromUpdateResponse(orderDetail);
    }

    @Override
    public DeleteOrderDetailResponse delete(UUID id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail with ID " + id + " not found."));
        orderDetailRepository.deleteById(id);
        return orderDetailMapper.orderDetailFromDeleteResponse(orderDetail);
    }


    @Override
    public GetByIdOrderDetailResponse getById(UUID id) {
        return orderDetailRepository.findById(id)
                .map(orderDetailMapper::orderDetailFromGetByIdResponse)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found with ID: " + id));
    }
}
