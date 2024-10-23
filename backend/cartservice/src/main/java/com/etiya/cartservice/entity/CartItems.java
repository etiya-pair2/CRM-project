package com.etiya.cartservice.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CartItems {
   private UUID id;
//  private UUID productId;
//  private UUID offerProductsId;
//  private UUID campaignProductId;
    private UUID cartId;
    private int quantity;
    private int unitPrice;
    private String productName;
    private String offerProductName;
    private String campaignProductName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean status;

}
