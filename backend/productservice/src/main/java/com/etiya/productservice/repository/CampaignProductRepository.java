package com.etiya.productservice.repository;

import com.etiya.productservice.entity.CampaignProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CampaignProductRepository extends JpaRepository<CampaignProduct, UUID> {
}
