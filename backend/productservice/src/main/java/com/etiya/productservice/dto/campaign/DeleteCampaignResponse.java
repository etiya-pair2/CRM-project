package com.etiya.productservice.dto.campaign;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class DeleteCampaignResponse {
    private UUID id;
    private String name;
}
