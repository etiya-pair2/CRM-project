package com.etiya.cartservice.repository;

import java.util.Map;
import java.util.UUID;

import com.etiya.cartservice.entity.Cart;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {
    private String Key="cart";

    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String,String, Cart> hashOperations;

    public CartRepository(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations=redisTemplate.opsForHash();
    }

    public Map<String,Cart> getAllItems(){
        return this.hashOperations.entries(Key);
    }

    public void addItem(Cart cart){
        this.hashOperations.put(Key, cart.getId().toString() + "_" + cart.getCustomerId().toString(), cart);
    }

   public Cart getCartByCustomerId(UUID customerId) {
        return hashOperations.entries(Key).values().stream()
           .filter(cart -> customerId.equals(cart.getCustomerId()))
           .findFirst()
            .orElse(null);
   }
}
