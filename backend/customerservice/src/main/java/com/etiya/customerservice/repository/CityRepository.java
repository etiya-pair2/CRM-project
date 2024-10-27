package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {
    boolean existsByName(String name);

}
