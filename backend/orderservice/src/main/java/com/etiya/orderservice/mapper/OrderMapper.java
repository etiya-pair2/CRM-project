package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.order.*;
import com.etiya.orderservice.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order orderFromCreateRequest(CreateOrderRequest dto);
    CreateOrderResponse orderFromCreateResponse (Order order);
    Order orderFromUpdateRequest(UpdateOrderRequest request);
    UpdateOrderResponse orderFromUpdateResponse(Order order);
    List<GetAllOrderResponse> orderFromGetAllResponse(List<Order> orders);
    GetByIdOrderResponse orderFromGetByIdResponse(Order order);
    DeleteOrderResponse orderFromDeleteResponse(Order order);
}
