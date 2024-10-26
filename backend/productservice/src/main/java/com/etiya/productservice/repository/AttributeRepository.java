package com.etiya.productservice.repository;

import com.etiya.productservice.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, UUID> {

    Optional<Attribute> findByNameIgnoreCase(String name);
}
