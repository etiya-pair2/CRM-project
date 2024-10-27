package com.etiya.customerservice.repository;

import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingAccountRepository extends JpaRepository<BillingAccount, UUID> {
    boolean existsByCustomerIdAndAddressId(UUID customerId, UUID addressId);

}
