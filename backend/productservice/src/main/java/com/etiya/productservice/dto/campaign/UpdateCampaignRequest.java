package com.etiya.productservice.dto.campaign;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UpdateCampaignRequest {

    private UUID id;

    @Size(min = 2, max = 30, message = "Campaign name must be between 2 and 30 characters")
    private String name;

    private double discount;

    private boolean status;
}
