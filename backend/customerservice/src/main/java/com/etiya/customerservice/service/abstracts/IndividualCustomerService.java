package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;

import java.util.List;
import java.util.UUID;

public interface IndividualCustomerService {

    CreateIndividualCustomerResponse create(CreateIndividualCustomerRequest request);
    UpdateIndividualCustomerResponse update(UpdateIndividualCustomerRequest request);
    DeleteIndividualCustomerResponse delete(UUID customerId);
    List<GetAllIndividualCustomerResponse> getAll();
    GetByIdIndividualCustomerResponse getById (UUID customerId);
    List<GetAllIndividualCustomerResponse> searchCustomer(SearchIndCustomerRequest request);

    GetByIdIndividualCustomerResponse findById(UUID id);
}
