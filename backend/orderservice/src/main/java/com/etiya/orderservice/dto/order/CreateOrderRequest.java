package com.etiya.orderservice.dto.order;

import com.etiya.orderservice.dto.ProductForOrderDto;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private List<ProductForOrderDto> products;
    private UUID billingAccountId;
    private UUID userId;
    private UUID orderAddressId;
    private Date date;
}