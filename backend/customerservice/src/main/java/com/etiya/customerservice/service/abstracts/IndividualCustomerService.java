package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.individualCustomer.*;

import java.util.List;
import java.util.UUID;

public interface IndividualCustomerService {

    CreateIndividualCustomerResponse create(CreateIndividualCustomerRequest request);
    UpdateIndividualCustomerResponse update(UpdateIndividualCustomerRequest request);

    DeleteIndividualCustomerResponse delete(UUID customerId);

    List<GetAllIndividualCustomerResponse> getAll();

    GetByIdIndividualCustomerResponse getById (UUID customerId);
}
