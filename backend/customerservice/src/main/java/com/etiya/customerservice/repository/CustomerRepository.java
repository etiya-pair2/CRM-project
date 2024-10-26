package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
