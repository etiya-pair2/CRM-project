package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.contactMedium.*;
import com.etiya.customerservice.entity.ContactMedium;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ContactMediumMapper {
    ContactMediumMapper INSTANCE= Mappers.getMapper(ContactMediumMapper.class);

    @Mapping(source="customer.id",target = "customerId")
    CreateContactMediumResponse contactMediumFromCreateResponse(ContactMedium contactMedium);
    @Mapping(source="customer.id",target = "customerId")
    UpdateContactMediumResponse contactMediumFromUpdateResponse (ContactMedium contactMedium);
    @Mapping(source="customer.id",target = "customerId")
    DeleteContactMediumResponse contactMediumFromDeleteResponse (ContactMedium contactMedium);
    @Mapping(source="customer.id",target = "customerId")
    GetAllContactMediumResponse contactMediumFromGetAllResponse (ContactMedium contactMediums);
    @Mapping(source="customer.id",target = "customerId")
    GetByIdContactMediumResponse getContactMediumById(ContactMedium contactMedium);
    @Mapping(source="customerId",target = "customer.id")
    ContactMedium contactMediumFromCreateRequest(CreateContactMediumRequest request);
    ContactMedium contactMediumFromUpdateRequest(UpdateContactMediumRequest request);
}
