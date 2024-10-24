package com.etiya.productservice.dto.offer;

import lombok.Data;

import java.util.Date;

@Data
public class CreateOfferRequest {
    private String name;
    private double discount;
}
