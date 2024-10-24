package com.etiya.productservice.dto.offer;

import lombok.Data;

import java.util.UUID;

@Data
public class DeleteOfferResponse {
    private UUID id;
    private String name;
}
