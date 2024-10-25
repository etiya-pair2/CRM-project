package com.etiya.cartservice.entity;


import lombok.*;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor

public class CartItem implements Serializable {
   private UUID id;
   private UUID productId;
   private UUID offerProductsId;
   private UUID campaignProductId;
//  private UUID cartId;
   private int quantity;
    private double unitPrice;
    private String productName;
    private String offerProductName;
    private String campaignProductName;
    private Date createdDate;
    private Date updatedDate;
    private Boolean status;

    public CartItem(){
        this.id = UUID.randomUUID();
    }

}
