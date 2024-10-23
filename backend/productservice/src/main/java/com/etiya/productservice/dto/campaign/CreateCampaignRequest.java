package com.etiya.productservice.dto.campaign;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class CreateCampaignRequest {
    private String name;
    private double discount;
}
