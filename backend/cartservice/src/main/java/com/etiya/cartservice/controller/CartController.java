package com.etiya.cartservice.controller;
import com.etiya.cartservice.dto.cart.*;
import com.etiya.cartservice.entity.Cart;
import com.etiya.cartservice.service.concretes.CartServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etiya.cartservice.service.abstracts.CartService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartService;

    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable String cartId) {
        return cartService.getCart(cartId);
    }

    @PostMapping
    public void createCart(@RequestBody Cart cart) {
        cartService.saveCart(cart);
    }

    @PutMapping
    public void updateCart(@RequestBody Cart cart) {
        cartService.updateCart(cart);
    }

    @DeleteMapping("/{cartId}")
    public void deleteCart(@PathVariable String cartId) {
        cartService.deleteCart(cartId);
    }
}

