package com.etiya.cartservice.controller;
import com.etiya.cartservice.dto.cart.*;
import com.etiya.cartservice.entity.Cart;
import com.etiya.cartservice.service.concretes.CartServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.etiya.cartservice.service.abstracts.CartService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cart/carts")

public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/customer-cart/product")
    public ResponseEntity<Void> addProductToCart(@RequestBody CreateCartItemRequest request) {
        cartService.add(request);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/{customerId}")
//    public ResponseEntity<Map<String, Cart>> getCartByCustomerId(@PathVariable UUID customerId) {
//        Cart cart = cartService.getCartByCustomerId(customerId);
//        if (cart != null) {
//            return ResponseEntity.ok(cart);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

    @GetMapping
    public ResponseEntity<Map<String, Cart>> getAllCarts() {
        return ResponseEntity.ok(cartService.getAllItems());
    }

    @GetMapping("/getCartByCustomerId/{customerId}")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable UUID customerId){
        return ResponseEntity.ok(cartService.getCartByCustomerId(customerId));
    }
}


