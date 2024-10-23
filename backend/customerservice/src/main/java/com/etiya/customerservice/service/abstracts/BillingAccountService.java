package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.billingAccount.*;
import com.etiya.customerservice.dto.contactMedium.*;

import java.util.List;
import java.util.UUID;

public interface BillingAccountService {
    CreateBillingAccountResponse create(CreateBillingAccountRequest request);

    UpdateBillingAccountResponse update(UpdateBillingAccountRequest request);

    DeleteBillingAccountResponse delete(UUID id);

    List<GetAllBillingAccountResponse> getAll();

    GetByIdBillingAccountResponse getById(UUID id);

}
