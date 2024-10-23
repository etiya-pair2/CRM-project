package com.etiya.cartservice.service.concretes;

import com.etiya.cartservice.dto.cart.*;
import com.etiya.cartservice.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.etiya.cartservice.repository.CartRepository;
import com.etiya.cartservice.service.abstracts.CartService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl {


    private final CartRepository cartRepository;

    // Sepeti al
    public Cart getCart(String cartId) {
        return cartRepository.findById(cartId);
    }

    // Sepeti kaydet
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    // Sepeti sil
    public void deleteCart(String cartId) {
        cartRepository.deleteById(cartId);
    }

    // Sepeti güncelle
    public void updateCart(Cart cart) {
        cartRepository.update(cart);
    }
}