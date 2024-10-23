package com.etiya.orderservice.dto.order;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOrderResponse {
    private UUID id;
}
