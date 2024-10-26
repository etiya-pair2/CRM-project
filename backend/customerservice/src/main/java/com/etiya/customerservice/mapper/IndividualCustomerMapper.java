package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.UUID;

@Mapper
public interface IndividualCustomerMapper {

    IndividualCustomerMapper INSTANCE= Mappers.getMapper(IndividualCustomerMapper.class);


    @Mapping(source = "id", target = "customerId")
    CreateIndividualCustomerResponse individualCustomerFromCreateResponse(IndividualCustomer individualCustomer);

    @Mapping(source = "id", target = "customerId")
    UpdateIndividualCustomerResponse individualCustomerFromUpdateResponse(IndividualCustomer individualCustomer);

    @Mapping(source = "id", target = "customerId")
    DeleteIndividualCustomerResponse individualCustomerFromDeleteResponse(IndividualCustomer individualCustomer);

    @Mapping(source = "id", target = "customerId")
    GetAllIndividualCustomerResponse individualCustomerFromGetAllResponse(IndividualCustomer individualCustomers);

    @Mapping(source = "id", target = "customerId")
    GetByIdIndividualCustomerResponse getIndividualCustomerById(IndividualCustomer individualCustomer);



    IndividualCustomer individualCustomerFromCreateRequest(CreateIndividualCustomerRequest request);


    IndividualCustomer individualCustomerFromUpdateRequest(UpdateIndividualCustomerRequest request);




}
