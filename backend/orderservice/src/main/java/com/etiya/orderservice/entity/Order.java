package com.etiya.orderservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "orders")
public class Order {
    @Id
    private UUID id;

    private UUID billingAccountId;
    private UUID userId;
    private UUID orderAddressId;
    private Date date;

    public Order() {
        this.id = UUID.randomUUID();
    }
}