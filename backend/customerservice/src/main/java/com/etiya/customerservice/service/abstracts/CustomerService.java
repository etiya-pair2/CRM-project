package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.customer.*;
import com.etiya.customerservice.dto.individualCustomer.*;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    CreateCustomerResponse create(CreateCustomerRequest request);
    UpdateCustomerResponse update(UpdateCustomerRequest request);

    DeleteCustomerResponse delete(UUID id);

    List<GetAllCustomerResponse> getAll();

    GetByIdCustomerResponse getById (UUID id);
}
