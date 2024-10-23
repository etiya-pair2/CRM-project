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
@Document(collection = "order_details")
public class OrderDetail {

    @Id
    private UUID id;

    private UUID productId;
    private int quantity;
    private double unitPrice;
    private double discount;

    public OrderDetail() {
        this.id = UUID.randomUUID();
    }
}
