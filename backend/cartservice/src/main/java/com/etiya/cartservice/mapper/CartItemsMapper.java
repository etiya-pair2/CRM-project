package com.etiya.cartservice.mapper;

import com.etiya.cartservice.dto.cartitems.*;
import com.etiya.cartservice.entity.CartItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

//@Mapper
//public interface CartItemsMapper {
//    CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    List<GetAllCartItemResponse> cartItemsFromGetAllResponse(List<CartItems> cartItems);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    GetByIdCartItemResponse cartItemsFromGetByIdResponse(CartItems cartItem);
//
//    @Mapping(source = "cartId", target = "cart.id")
//    CartItems cartItemsFromCreateRequest(CreateCartItemRequest request);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    CreateCartItemResponse cartItemsFromCreateResponse(CartItems cartItem);
//
//    @Mapping(source = "cartId", target = "cart.id")
//    CartItems cartItemsFromUpdateRequest(UpdateCartItemRequest request);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    UpdateCartItemResponse cartItemsFromUpdateResponse(CartItems cartItem);
//
//    DeleteCartItemResponse cartItemsFromDeleteResponse(CartItems cartItem);
//}