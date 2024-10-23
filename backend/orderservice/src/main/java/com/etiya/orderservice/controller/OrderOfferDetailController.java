package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.orderOfferDetail.*;
import com.etiya.orderservice.service.abstracts.OrderOfferDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order/order-offer-details")
@RequiredArgsConstructor
public class OrderOfferDetailController {

    private final OrderOfferDetailService orderOfferDetailService;

    @GetMapping
    public ResponseEntity<List<GetAllOrderOfferDetailResponse>> getAll() {
        List<GetAllOrderOfferDetailResponse> response = orderOfferDetailService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdOrderOfferDetailResponse> getById(@PathVariable UUID id) {
        GetByIdOrderOfferDetailResponse response = orderOfferDetailService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateOrderOfferDetailResponse> create(@RequestBody CreateOrderOfferDetailRequest request) {
        CreateOrderOfferDetailResponse response = orderOfferDetailService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderOfferDetailResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdateOrderOfferDetailRequest request) {
        request.setId(id);
        UpdateOrderOfferDetailResponse response = orderOfferDetailService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderOfferDetailResponse> delete(@PathVariable UUID id) {
        DeleteOrderOfferDetailResponse response = orderOfferDetailService.delete(id);
        return ResponseEntity.ok(response);
    }
}
