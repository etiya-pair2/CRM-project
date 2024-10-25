package com.etiya.cartservice.dto.cart;


import com.etiya.cartservice.dto.cartitems.CreateCartItemRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartResponse {
    private UUID id;
    private Date createdDate;
    private List<CreateCartItemRequest> cartItems;



}
