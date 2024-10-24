package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferRequest;
import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferResponse;
import com.etiya.customerservice.service.abstracts.CustomerOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer-offer")
@RequiredArgsConstructor
public class CustomerOfferController {

    private final CustomerOfferService service;

    @PostMapping("/create")
    public ResponseEntity<CreateCustomerOfferResponse> create(@RequestBody CreateCustomerOfferRequest request) {
        return new ResponseEntity<>(service.create(request), HttpStatus.OK);
    }
}
