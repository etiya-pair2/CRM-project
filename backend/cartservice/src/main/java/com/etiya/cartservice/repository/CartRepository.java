package com.etiya.cartservice.repository;



import java.util.UUID;

import com.etiya.cartservice.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.sabaurgup.caching.RedisConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartRepository {

    private static final String CART_PREFIX = "cart:"; // Redis anahtar ön eki

    @Autowired
    private RedisTemplate<String, Cart> redisTemplate;

    // Sepeti kaydetme
    public void save(Cart cart) {
        redisTemplate.opsForValue().set(CART_PREFIX + cart.getId(), cart);
    }

    // Sepeti alma
    public Cart findById(String cartId) {
        return redisTemplate.opsForValue().get(CART_PREFIX + cartId);
    }

    // Sepeti silme
    public void deleteById(String cartId) {
        redisTemplate.delete(CART_PREFIX + cartId);
    }

    // Sepeti güncelleme (güncelleme işlemi save metoduyla yapılabilir)
    public void update(Cart cart) {
        save(cart);
    }
}
