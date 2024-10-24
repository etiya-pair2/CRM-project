package com.etiya.productservice.dto.offer;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class GetAllOfferResponse {
    private UUID id;
    private String name;
    private Date createdDate;
    private boolean status;
    private double discount;
}
