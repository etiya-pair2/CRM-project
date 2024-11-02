package com.etiya.cartservice.entity;

import lombok.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private UUID customerId;
    private Boolean status;
    private double totalPrice;
    private List<CartItem> cartItems;

    public Cart(){
        this.cartItems = new ArrayList<>();
        this.id= UUID.randomUUID();
    }

}