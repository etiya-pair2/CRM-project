package com.etiya.orderservice.mapper;

import com.etiya.orderservice.dto.billingAccountProduct.*;
import com.etiya.orderservice.entity.BillingAccountProduct;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BillingAccountProductMapper {
    BillingAccountProductMapper INSTANCE = Mappers.getMapper(BillingAccountProductMapper.class);

    BillingAccountProduct billingAccountProductFromCreateRequest(CreateBillingAccountProductRequest dto);
    CreateBillingAccountProductResponse billingAccountProductFromCreateResponse (BillingAccountProduct billingAccountProduct);
    BillingAccountProduct billingAccountProductFromUpdateRequest(UpdateBillingAccountProductRequest request);
    UpdateBillingAccountProductResponse billingAccountProductFromUpdateResponse(BillingAccountProduct billingAccountProduct);
    List<GetAllBillingAccountProductResponse> billingAccountProductFromGetAllResponse(List<BillingAccountProduct> billingAccountProducts);
    GetByIdBillingAccountProductResponse billingAccountProductFromGetByIdResponse(BillingAccountProduct billingAccountProduct);
    DeleteBillingAccountProductResponse billingAccountProductFromDeleteResponse(BillingAccountProduct billingAccountProduct);
}
