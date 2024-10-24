package com.etiya.customerservice.dto.customerOffer;

import lombok.Data;

import java.util.UUID;

@Data
public class CreateCustomerOfferResponse {
    private UUID id;
    private UUID customerId;
    private UUID offerId;
}
