package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.orderCampaignDetail.*;
import com.etiya.orderservice.service.abstracts.OrderCampaignDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order/order-campaign-details")
@RequiredArgsConstructor
public class OrderCampaignDetailController {

    private final OrderCampaignDetailService orderCampaignDetailService;

    @GetMapping
    public ResponseEntity<List<GetAllOrderCampaignDetailResponse>> getAll() {
        List<GetAllOrderCampaignDetailResponse> response = orderCampaignDetailService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdOrderCampaignDetailResponse> getById(@PathVariable UUID id) {
        GetByIdOrderCampaignDetailResponse response = orderCampaignDetailService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateOrderCampaignDetailResponse> create(@RequestBody CreateOrderCampaignDetailRequest request) {
        CreateOrderCampaignDetailResponse response = orderCampaignDetailService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderCampaignDetailResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdateOrderCampaignDetailRequest request) {
        request.setId(id);
        UpdateOrderCampaignDetailResponse response = orderCampaignDetailService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderCampaignDetailResponse> delete(@PathVariable UUID id) {
        DeleteOrderCampaignDetailResponse response = orderCampaignDetailService.delete(id);
        return ResponseEntity.ok(response);
    }
}
