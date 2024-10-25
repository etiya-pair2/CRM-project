package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporateCustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CorporateCustomerMapper {

    CorporateCustomerMapper INSTANCE= Mappers.getMapper(CorporateCustomerMapper.class);

    @Mapping(source = "id", target = "customerId")
    CreateCorporateCustomerResponse corporateCustomerFromCreateResponse(CorporateCustomer corporateCustomer);

    @Mapping(source = "id", target = "customerId")
    UpdateCorporateCustomerResponse corporateCustomerFromUpdateResponse( CorporateCustomer corporateCustomer);

    DeleteCorporateCustomerResponse corporateCustomerFromDeleteResponse (CorporateCustomer corporateCustomer);

    GetAllCorporateCustomerResponse corporateCustomerFromGetAllResponse(CorporateCustomer corporateCustomers);

    GetByIdCorporateCustomerResponse getCustomerById( CorporateCustomer corporateCustomer);

    CorporateCustomer corporateCustomerFromCreateRequest(CreateCorporateCustomerRequest request);

    CorporateCustomer corporateCustomerFromUpdateRequest (UpdateCorporateCustomerRequest request);
}
