package com.etiya.orderservice.entity;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID billingAccountId;
    private UUID userId;
    private UUID orderAddressId;
    private LocalDate date;
    private List<Product> products;
    public Order() {
        this.id = UUID.randomUUID();
    }
}