package com.etiya.cartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Cart implements Serializable {
    private UUID id;
    private UUID customerId;
    private Date createdDate;
    private Date updatedDate;
    private Boolean status;
    private List<CartItems> cartItems;
}