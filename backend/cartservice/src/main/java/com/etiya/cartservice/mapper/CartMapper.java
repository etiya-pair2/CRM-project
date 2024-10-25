
//package com.etiya.cartservice.mapper;
//import com.etiya.cartservice.dto.cart.GetAllCartResponse;
//import com.etiya.cartservice.dto.cart.*;
//import com.etiya.cartservice.entity.Cart;
//import org.mapstruct.factory.Mappers;
//import org.mapstruct.Mapper;
//import java.util.List;
//
//@Mapper
//public interface CartMapper {
//    CartMapper INSTANCE = Mappers.getMapper(CartMapper.class);
//
//    List<GetAllCartResponse> cartFromGetAllResponse(List<Cart> carts);
//
//    GetByIdCartResponse cartFromGetByIdResponse(Cart cart);
//
//    Cart cartFromCreateRequest(CreateCartRequest request);
//
//    CreateCartResponse cartFromCreateResponse(Cart cart);
//
//    Cart cartFromUpdateRequest(UpdateCartRequest request);
//
//    UpdateCartResponse cartFromUpdateResponse(Cart cart);
//
//    DeleteCartResponse cartFromDeleteResponse(Cart cart);
//}
