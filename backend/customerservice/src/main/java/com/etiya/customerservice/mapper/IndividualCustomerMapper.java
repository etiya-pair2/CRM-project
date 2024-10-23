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


    CreateIndividualCustomerResponse individualCustomerFromCreateResponse(IndividualCustomer individualCustomer);

    UpdateIndividualCustomerResponse individualCustomerFromUpdateResponse(IndividualCustomer individualCustomer);

    DeleteIndividualCustomerResponse individualCustomerFromDeleteResponse(IndividualCustomer individualCustomer);

    List<GetAllIndividualCustomerResponse> individualCustomerFromGetAllResponse(List<IndividualCustomer> individualCustomers);

    GetByIdIndividualCustomerResponse getIndividualCustomerById(IndividualCustomer individualCustomer);

    IndividualCustomer individualCustomerFromCreateRequest(CreateIndividualCustomerRequest request);

    IndividualCustomer individualCustomerFromUpdateRequest(UpdateIndividualCustomerRequest request);




}
