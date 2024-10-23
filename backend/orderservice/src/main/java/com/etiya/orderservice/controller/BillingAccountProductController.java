package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.billingAccountProduct.*;
import com.etiya.orderservice.service.abstracts.BillingAccountProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order/billing-account-products")
@RequiredArgsConstructor
public class BillingAccountProductController {

    private final BillingAccountProductService billingAccountProductService;

    @GetMapping
    public ResponseEntity<List<GetAllBillingAccountProductResponse>> getAll() {
        List<GetAllBillingAccountProductResponse> response = billingAccountProductService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdBillingAccountProductResponse> getById(@PathVariable UUID id) {
        GetByIdBillingAccountProductResponse response = billingAccountProductService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateBillingAccountProductResponse> create(@RequestBody CreateBillingAccountProductRequest request) {
        CreateBillingAccountProductResponse response = billingAccountProductService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateBillingAccountProductResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdateBillingAccountProductRequest request) {
        request.setId(id);
        UpdateBillingAccountProductResponse response = billingAccountProductService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteBillingAccountProductResponse> delete(@PathVariable UUID id) {
        DeleteBillingAccountProductResponse response = billingAccountProductService.delete(id);
        return ResponseEntity.ok(response);
    }
}
