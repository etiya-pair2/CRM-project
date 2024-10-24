package com.etiya.customerservice.dto.customerOffer;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateCustomerOfferRequest {
    private UUID customerId;
    private UUID offerId;
}
