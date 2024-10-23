package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.orderOfferDetail.*;
import com.etiya.orderservice.entity.OrderOfferDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderOfferDetailMapper {
    OrderOfferDetailMapper INSTANCE = Mappers.getMapper(OrderOfferDetailMapper.class);

    OrderOfferDetail orderOfferDetailFromCreateRequest(CreateOrderOfferDetailRequest dto);
    CreateOrderOfferDetailResponse orderOfferDetailFromCreateResponse (OrderOfferDetail orderOfferDetail);
    OrderOfferDetail orderOfferDetailFromUpdateRequest(UpdateOrderOfferDetailRequest request);
    UpdateOrderOfferDetailResponse orderOfferDetailFromUpdateResponse(OrderOfferDetail orderOfferDetail);
    List<GetAllOrderOfferDetailResponse> orderOfferDetailFromGetAllResponse(List<OrderOfferDetail> orderOfferDetails);
    GetByIdOrderOfferDetailResponse orderOfferDetailFromGetByIdResponse(OrderOfferDetail orderOfferDetail);
    DeleteOrderOfferDetailResponse orderOfferDetailFromDeleteResponse(OrderOfferDetail orderOfferDetail);
}
