package com.etiya.cartservice.service.abstracts;

import com.etiya.cartservice.dto.cart.*;
import com.etiya.cartservice.entity.Cart;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface CartService {

    void add(UUID customerId,UUID productId);
     Map<String, Cart> getAllItems();

}
