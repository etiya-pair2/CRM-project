package com.etiya.productservice.dto.offer;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UpdateOfferRequest {
    private UUID id;
    private String name;
    private boolean status;
    private double discount;
}
