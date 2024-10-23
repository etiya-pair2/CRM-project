package com.etiya.cartservice.dto.cartitems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCartItemResponse {
    private UUID id;
    private UUID cartId; // Sepetin ID'si
    private int quantity;
    private int unitPrice;
    private String productName;
    private String offerProductName;
    private String campaignProductName;
    private Date createdDate;

}
