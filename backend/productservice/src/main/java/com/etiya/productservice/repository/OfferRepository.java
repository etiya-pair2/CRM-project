package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {
}
