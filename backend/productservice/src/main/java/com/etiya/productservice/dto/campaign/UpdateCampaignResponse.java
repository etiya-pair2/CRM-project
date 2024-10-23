package com.etiya.productservice.dto.campaign;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class UpdateCampaignResponse {
    private UUID id;
    private String name;
    private boolean status;
    private double discount;
    private Date createdDate;


}
