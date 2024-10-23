package com.etiya.orderservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "order_offer_details")
public class OrderOfferDetail {
    @Id
    private UUID id;

    private UUID offerProductsId;
    private int quantity;
    private double unitPrice;
    private double discount;

    public OrderOfferDetail() {
        this.id = UUID.randomUUID();
    }
}
