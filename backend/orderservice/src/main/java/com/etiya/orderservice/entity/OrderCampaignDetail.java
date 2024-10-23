package com.etiya.orderservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "order_campaign_details")
public class OrderCampaignDetail {

    @Id
    private UUID id;

    private UUID campaignProductsId;
    private int quantity;
    private double unitPrice;
    private double discount;

    public OrderCampaignDetail() {
        this.id = UUID.randomUUID();
    }
}
