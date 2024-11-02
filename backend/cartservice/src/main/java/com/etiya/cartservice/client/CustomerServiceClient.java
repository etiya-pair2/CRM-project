package com.etiya.cartservice.client;

import com.etiya.cartservice.entity.IndividualCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name="customerservice")
public interface CustomerServiceClient {
    @GetMapping("/api/v1/customer/individualCustomers/search/{id}")
    IndividualCustomer findById(@PathVariable UUID id);
}
