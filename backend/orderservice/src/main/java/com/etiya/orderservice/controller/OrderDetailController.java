package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.orderDetail.*;
import com.etiya.orderservice.service.abstracts.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order/order-details")
@RequiredArgsConstructor
public class OrderDetailController {

    private final OrderDetailService orderDetailService;

    @GetMapping
    public ResponseEntity<List<GetAllOrderDetailResponse>> getAll() {
        List<GetAllOrderDetailResponse> response = orderDetailService.getAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdOrderDetailResponse> getById(@PathVariable UUID id) {
        GetByIdOrderDetailResponse response = orderDetailService.getById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CreateOrderDetailResponse> create(@RequestBody CreateOrderDetailRequest request) {
        CreateOrderDetailResponse response = orderDetailService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderDetailResponse> update(
            @PathVariable UUID id,
            @RequestBody UpdateOrderDetailRequest request) {
        request.setId(id);
        UpdateOrderDetailResponse response = orderDetailService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderDetailResponse> delete(@PathVariable UUID id) {
        DeleteOrderDetailResponse response = orderDetailService.delete(id);
        return ResponseEntity.ok(response);
    }
}
