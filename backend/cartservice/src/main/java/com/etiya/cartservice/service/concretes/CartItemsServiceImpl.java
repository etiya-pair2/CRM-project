//package com.etiya.cartservice.service.concretes;
//
//import com.etiya.cartservice.dto.cartitems.*;
//import com.etiya.cartservice.entity.CartItem;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import com.etiya.cartservice.repository.CartItemsRepository;
//import com.etiya.cartservice.service.abstracts.CartItemsService;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//@RequiredArgsConstructor
//public class CartItemsServiceImpl implements CartItemsService {
//    private final CartItemsRepository cartItemsRepository;
//
//    @Override
//    public List<GetAllCartItemResponse> getAll() {
//        List<CartItem> cartItems = cartItemsRepository.findAll();
//        return CartItemsMapper.INSTANCE.cartItemsFromGetAllResponse(cartItems);
//    }
//
//    @Override
//    public GetByIdCartItemResponse getById(UUID id) {
//        CartItem cartItem = cartItemsRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cart Item not found"));
//        return CartItemsMapper.INSTANCE.cartItemsFromGetByIdResponse(cartItem);
//    }
//
//    @Override
//    public CreateCartItemResponse create(CreateCartItemRequest request) {
//        CartItem cartItem = CartItemsMapper.INSTANCE.cartItemsFromCreateRequest(request);
//        cartItemsRepository.save(cartItem);
//        return CartItemsMapper.INSTANCE.cartItemsFromCreateResponse(cartItem);
//    }
//
//    @Override
//    public UpdateCartItemResponse update(UpdateCartItemRequest request) {
//        CartItem cartItem = CartItemsMapper.INSTANCE.cartItemsFromUpdateRequest(request);
//        cartItemsRepository.save(cartItem);
//        return CartItemsMapper.INSTANCE.cartItemsFromUpdateResponse(cartItem);
//    }
//
//    @Override
//    public DeleteCartItemResponse delete(UUID id) {
//        CartItem cartItem = cartItemsRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cart Item not found"));
//        cartItemsRepository.delete(cartItem);
//        return CartItemsMapper.INSTANCE.cartItemsFromDeleteResponse(cartItem);
//    }
//}