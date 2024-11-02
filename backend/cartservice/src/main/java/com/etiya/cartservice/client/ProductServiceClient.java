package com.etiya.cartservice.client;

import com.etiya.cartservice.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@FeignClient(name="productservice")
public interface ProductServiceClient {

    @GetMapping("/api/v1/product/products/getById/{productId}")
    Product findById(@PathVariable UUID productId);
}
