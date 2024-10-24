package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.CustomerOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerOfferRepository extends JpaRepository<CustomerOffer, UUID> {
}
