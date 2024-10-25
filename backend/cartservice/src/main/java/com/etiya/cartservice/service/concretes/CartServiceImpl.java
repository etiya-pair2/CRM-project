package com.etiya.cartservice.service.concretes;

import com.etiya.cartservice.entity.Cart;
import com.etiya.cartservice.entity.CartItem;
import com.etiya.cartservice.service.abstracts.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.etiya.cartservice.repository.CartRepository;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl  implements CartService {

    private final CartRepository cartRepository;

    @Override
    public void add(UUID customerId, UUID productId) {
        Cart cart = cartRepository.getCartByCustomerId(customerId);

        if (cart == null) {
            cart = new Cart();
            cart.setCustomerId(customerId);
        }
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setProductName("Modem");
        cartItem.setUnitPrice(2000);
        cart.setCustomerId(customerId);
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getUnitPrice()); // Toplam fiyatı güncelle
        cart.getCartItems().add(cartItem); // Ürünü sepete ekle

        try {
            cartRepository.addItem(cart);
        } catch (Exception e) {
            System.err.println("Error adding cart to Redis: " + e.getMessage());
        }// Sepeti güncelle
    }

    @Override
    public Map<String, Cart> getAllItems() {
        return cartRepository.getAllItems(); // 'Basket' yerine 'Cart' kullan
    }
}