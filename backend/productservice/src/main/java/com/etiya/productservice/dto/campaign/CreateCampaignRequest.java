package com.etiya.productservice.dto.campaign;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class CreateCampaignRequest {

    @Size(min = 2, max = 30, message = "Campaign name must be between 2 and 30 characters")
    private String name;

    private double discount;
}
