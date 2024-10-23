package com.etiya.orderservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "billing_account_products")
public class BillingAccountProduct {
    @Id
    private UUID id;

    private UUID orderId;
    private UUID billingAccountId;
    private UUID productId;

    public BillingAccountProduct() {
        this.id = UUID.randomUUID();
    }
}