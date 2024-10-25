package com.etiya.customerservice.mapper;
import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AddressMapper {
    AddressMapper INSTANCE= Mappers.getMapper(AddressMapper.class);
    @Mapping(source = "customer.id",target="customerId")
    @Mapping(source = "district.id",target="districtId")
    CreateAddressResponse addressFromCreateResponse(Address address);
    @Mapping(source = "customer.id",target="customerId")
    @Mapping(source = "district.id",target="districtId")
    UpdateAddressResponse addressFromUpdateResponse( Address address);
    @Mapping(source = "customer.id",target="customerId")
    @Mapping(source = "district.id",target="districtId")
    DeleteAddressResponse addressFromDeleteResponse (Address address);
    @Mapping(source = "customer.id",target="customerId")
    @Mapping(source = "district.id",target="districtId")
    GetAllAddressResponse addressFromGetAllResponse (Address addresses);

    @Mapping(source = "customer.id",target="customerId")
    @Mapping(source = "district.id",target="districtId")
    GetByIdAddressResponse getAddressById(Address address);

    @Mapping(source = "customerId",target="customer.id")
    @Mapping(source = "districtId",target="district.id")
    Address addressFromCreateRequest(CreateAddressRequest request);
    @Mapping(source = "customerId",target="customer.id")
    @Mapping(source = "districtId",target="district.id")
    Address addressFromUpdateRequest(UpdateAddressRequest request);
}
