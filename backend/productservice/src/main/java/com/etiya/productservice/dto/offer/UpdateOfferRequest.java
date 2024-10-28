package com.etiya.productservice.dto.offer;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UpdateOfferRequest {
    private UUID id;

    @Size(min = 2, max = 30, message = "Offer name must be between 2 and 30 characters")
    private String name;
    private boolean status;
    private double discount;
}
