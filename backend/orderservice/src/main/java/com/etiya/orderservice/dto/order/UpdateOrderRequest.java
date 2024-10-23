package com.etiya.orderservice.dto.order;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {
    private UUID id;
    private UUID billingAccountId;
    private UUID userId;
    private UUID orderAddressId;
    private Date date;
}
