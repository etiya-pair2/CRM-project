package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferRequest;
import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferResponse;

public interface CustomerOfferService {
    CreateCustomerOfferResponse create(CreateCustomerOfferRequest request);

}
