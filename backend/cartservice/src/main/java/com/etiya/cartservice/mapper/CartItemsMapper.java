//package com.etiya.cartservice.mapper;
//
//import com.etiya.cartservice.dto.cartitems.*;
//import com.etiya.cartservice.entity.CartItem;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper
//public interface CartItemsMapper {
//    CartItemsMapper INSTANCE = Mappers.getMapper(CartItemsMapper.class);

//    @Mapping(source = "cart.id", target = "cartId")
//    List<GetAllCartItemResponse> cartItemsFromGetAllResponse(List<CartItem> cartItems);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    GetByIdCartItemResponse cartItemsFromGetByIdResponse(CartItem cartItem);
//
//    @Mapping(source = "cartId", target = "cart.id")
//    CartItem cartItemsFromCreateRequest(CreateCartItemRequest request);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    CreateCartItemResponse cartItemsFromCreateResponse(CartItem cartItem);
//
//    @Mapping(source = "cartId", target = "cart.id")
//    CartItem cartItemsFromUpdateRequest(UpdateCartItemRequest request);
//
//    @Mapping(source = "cart.id", target = "cartId")
//    UpdateCartItemResponse cartItemsFromUpdateResponse(CartItem cartItem);
//
//    DeleteCartItemResponse cartItemsFromDeleteResponse(CartItem cartItem);
//}