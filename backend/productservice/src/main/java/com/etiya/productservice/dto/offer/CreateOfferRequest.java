package com.etiya.productservice.dto.offer;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class CreateOfferRequest {

    @Size(min = 2, max = 30, message = "Offer name must be between 2 and 30 characters")
    private String name;
    private double discount;
}
