package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.orderDetail.*;
import com.etiya.orderservice.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailMapper INSTANCE = Mappers.getMapper(OrderDetailMapper.class);

    OrderDetail orderDetailFromCreateRequest(CreateOrderDetailRequest dto);
    CreateOrderDetailResponse orderDetailFromCreateResponse (OrderDetail orderDetail);
    OrderDetail orderDetailFromUpdateRequest(UpdateOrderDetailRequest request);
    UpdateOrderDetailResponse orderDetailFromUpdateResponse(OrderDetail orderDetail);
    List<GetAllOrderDetailResponse> orderDetailFromGetAllResponse(List<OrderDetail> orderDetails);
    GetByIdOrderDetailResponse orderDetailFromGetByIdResponse(OrderDetail orderDetail);
    DeleteOrderDetailResponse orderDetailFromDeleteResponse(OrderDetail orderDetail);
}
