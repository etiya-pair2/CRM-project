package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.ContactMedium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactMediumRepository extends JpaRepository<ContactMedium, UUID> {
}
