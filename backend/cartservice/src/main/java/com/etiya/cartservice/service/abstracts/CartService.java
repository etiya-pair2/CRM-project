package com.etiya.cartservice.service.abstracts;

import com.etiya.cartservice.dto.cart.*;

import java.util.List;
import java.util.UUID;

public interface CartService {
    List<GetAllCartResponse> getAll();
    GetByIdCartResponse getById(UUID id);
    CreateCartResponse create(CreateCartRequest request);
    UpdateCartResponse update(UpdateCartRequest request);
    DeleteCartResponse delete(UUID id);
}
