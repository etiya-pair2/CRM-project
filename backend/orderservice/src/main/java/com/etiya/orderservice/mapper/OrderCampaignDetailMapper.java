package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.orderCampaignDetail.*;
import com.etiya.orderservice.entity.OrderCampaignDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderCampaignDetailMapper {
    OrderCampaignDetailMapper INSTANCE = Mappers.getMapper(OrderCampaignDetailMapper.class);

    OrderCampaignDetail orderCampaignDetailFromCreateRequest(CreateOrderCampaignDetailRequest dto);
    CreateOrderCampaignDetailResponse orderCampaignDetailFromCreateResponse (OrderCampaignDetail orderCampaignDetail);
    OrderCampaignDetail orderCampaignDetailFromUpdateRequest(UpdateOrderCampaignDetailRequest request);
    UpdateOrderCampaignDetailResponse orderCampaignDetailFromUpdateResponse(OrderCampaignDetail orderCampaignDetail);
    List<GetAllOrderCampaignDetailResponse> orderCampaignDetailFromGetAllResponse(List<OrderCampaignDetail> orderCampaignDetails);
    GetByIdOrderCampaignDetailResponse orderCampaignDetailFromGetByIdResponse(OrderCampaignDetail orderCampaignDetail);
    DeleteOrderCampaignDetailResponse orderCampaignDetailFromDeleteResponse(OrderCampaignDetail orderCampaignDetail);
}
