package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.customer.*;
import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);

    CreateCustomerResponse customerFromCreateResponse(Customer customer);

    UpdateCustomerResponse customerFromUpdateResponse(Customer customer);

    DeleteCustomerResponse customerFromDeleteResponse(Customer customer);

    GetAllCustomerResponse customerFromGetAllResponse(Customer customers);

    GetByIdCustomerResponse getCustomerById(Customer customer);

    Customer customerFromCreateRequest(CreateCustomerRequest request);

    Customer customerFromUpdateRequest(UpdateCustomerRequest request);
}
