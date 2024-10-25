package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.billingAccount.*;
import com.etiya.customerservice.entity.BillingAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface BillingAccountMapper {
    BillingAccountMapper INSTANCE= Mappers.getMapper(BillingAccountMapper.class);
    @Mapping(source="customer.id",target = "customerId")
    CreateBillingAccountResponse billingAccountFromCreateResponse(BillingAccount billingAccount);
    @Mapping(source="customer.id",target = "customerId")
    UpdateBillingAccountResponse billingAccountFromUpdateResponse(BillingAccount billingAccount);
    @Mapping(source="customer.id",target = "customerId")
    DeleteBillingAccountResponse billingAccountFromDeleteResponse(BillingAccount billingAccount);
    @Mapping(source="customer.id",target = "customerId")
    GetAllBillingAccountResponse billingAccountFromGetAllResponse(BillingAccount billingAccounts);
    @Mapping(source="customer.id",target = "customerId")
    GetByIdBillingAccountResponse getBillingAccountById(BillingAccount billingAccount);
    @Mapping(source="customerId",target = "customer.id")
    BillingAccount billingAccountFromCreateRequest(CreateBillingAccountRequest request);
    @Mapping(source="customerId",target = "customer.id")
    BillingAccount billingAccountFromUpdateRequest(UpdateBillingAccountRequest request);
}
