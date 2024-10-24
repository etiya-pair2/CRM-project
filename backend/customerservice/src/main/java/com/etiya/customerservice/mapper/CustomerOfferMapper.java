package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferRequest;
import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferResponse;
import com.etiya.customerservice.entity.CustomerOffer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerOfferMapper {

    CustomerOfferMapper INSTANCE = Mappers.getMapper(CustomerOfferMapper.class);

    @Mapping(source = "customer.id", target = "customerId")
    CreateCustomerOfferResponse customerOfferFromCreateResponse(CustomerOffer customerOffer);
    @Mapping(source = "customerId", target = "customer.id")
    CustomerOffer customerOfferFromCreateRequest(CreateCustomerOfferRequest request);


}
