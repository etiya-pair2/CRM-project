package com.etiya.customerservice.client;

import com.etiya.customerservice.entity.Offer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(name="productservice")
public interface ProductServiceClient {

    @GetMapping("/api/v1/offer/search/{id}")
    Offer findById(@PathVariable UUID id);
}
