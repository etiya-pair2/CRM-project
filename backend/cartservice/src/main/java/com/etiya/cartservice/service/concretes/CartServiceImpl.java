package com.etiya.cartservice.service.concretes;

import com.etiya.cartservice.client.CustomerServiceClient;
import com.etiya.cartservice.client.ProductServiceClient;
import com.etiya.cartservice.dto.cart.CreateCartItemRequest;
import com.etiya.cartservice.dto.cart.ProductForCartDto;
import com.etiya.cartservice.entity.Cart;
import com.etiya.cartservice.entity.CartItem;
import com.etiya.cartservice.entity.Product;
import com.etiya.cartservice.rules.CartBusinessRules;
import com.etiya.cartservice.service.abstracts.CartService;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.etiya.cartservice.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CartServiceImpl  implements CartService {

    private final CartRepository cartRepository;
    private final CartBusinessRules cartBusinessRules;
    private final ProductServiceClient productServiceClient;

    @Override
    public void add(CreateCartItemRequest request) {
        cartBusinessRules.existByCustomer(request.getCustomerId());
        Cart cart = cartRepository.getCartByCustomerId(request.getCustomerId());
        if (cart == null) {
            cart = new Cart();
            cart.setCustomerId(request.getCustomerId());
        }
        CartItem cartItem = new CartItem();


        Product checkProduct = productServiceClient.findById(request.getProduct().getProductId());

        cartItem.setProductId(checkProduct.getId());
        cartItem.setQuantity(request.getProduct().getQuantity());
        cartItem.setProductName(checkProduct.getName());
        cartItem.setUnitPrice(checkProduct.getUnitPrice());


        cart.setCustomerId(request.getCustomerId());
        cart.setTotalPrice(cart.getTotalPrice() + cartItem.getUnitPrice() * cartItem.getQuantity()); // Toplam fiyatı güncelle
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

    @Override
    public Cart getCartByCustomerId(UUID customerId) {
        return cartRepository.getCartByCustomerId(customerId);
    }
}