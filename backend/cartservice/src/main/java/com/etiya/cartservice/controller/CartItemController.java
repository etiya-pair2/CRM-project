package com.etiya.cartservice.controller;

import com.etiya.cartservice.dto.cartitems.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etiya.cartservice.service.abstracts.CartItemsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart/cart-items")
@RequiredArgsConstructor
public class CartItemController {

//    private final CartItemsService cartItemsService;
//
//    @GetMapping("/getAll")
//    public List<GetAllCartItemResponse> getAll() {
//        return cartItemsService.getAll();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<GetByIdCartItemResponse> getById(@PathVariable UUID id) {
//        GetByIdCartItemResponse response = cartItemsService.getById(id);
//        return ResponseEntity.ok(response);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<CreateCartItemResponse> create(@RequestBody @Valid CreateCartItemRequest request) {
//        CreateCartItemResponse response = cartItemsService.create(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<UpdateCartItemResponse> update(@RequestBody @Valid UpdateCartItemRequest request) {
//        UpdateCartItemResponse response = cartItemsService.update(request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<DeleteCartItemResponse> delete(@PathVariable UUID id) {
//        DeleteCartItemResponse response = cartItemsService.delete(id);
//        return ResponseEntity.ok(response);
//    }
}