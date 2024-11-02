package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DistrictRepository extends JpaRepository<District, UUID> {

    List<District> findByCityId(UUID id);
}
