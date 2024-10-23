package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.corporateCustomer.*;
import com.etiya.customerservice.dto.customer.*;

import java.util.List;
import java.util.UUID;

public interface CorporateCustomerService {
    CreateCorporateCustomerResponse create(CreateCorporateCustomerRequest request);
    UpdateCorporateCustomerResponse update(UpdateCorporateCustomerRequest request);

    DeleteCorporateCustomerResponse delete(UUID id);

    List<GetAllCorporateCustomerResponse> getAll();

    GetByIdCorporateCustomerResponse getById (UUID id);
}
