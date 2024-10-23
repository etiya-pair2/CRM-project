package com.etiya.orderservice.controller;

import com.etiya.orderservice.dto.order.*;
import com.etiya.orderservice.service.abstracts.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order/orders")
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;
    //TODO: Convert all to dto
/*    @GetMapping()
    public ResponseEntity<List<Order>> getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody CreateOrderRequest orderRequest)
    {
        orderService.add(orderRequest);
        return ResponseEntity.ok("Eklendi");
    }*/

    @GetMapping
    public ResponseEntity<List<GetAllOrderResponse>> getAll() {
        List<GetAllOrderResponse> orders = orderService.getAll();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdOrderResponse> getById(@PathVariable UUID id) {
        GetByIdOrderResponse orderResponse = orderService.getById(id);
        return ResponseEntity.ok(orderResponse);
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> create(@RequestBody CreateOrderRequest request) {
        CreateOrderResponse response = orderService.create(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateOrderResponse> update(@PathVariable UUID id, @RequestBody UpdateOrderRequest request) {
        request.setId(id);
        UpdateOrderResponse response = orderService.update(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteOrderResponse> delete(@PathVariable UUID id) {
        DeleteOrderResponse response = orderService.delete(id);
        return ResponseEntity.ok(response);
    }

}