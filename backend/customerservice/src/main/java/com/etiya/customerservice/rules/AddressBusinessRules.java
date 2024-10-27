package com.etiya.customerservice.rules;

import com.etiya.customerservice.core.configuration.exceptions.type.BusinessException;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class AddressBusinessRules {

    private final CustomerRepository customerRepository;

    private final DistrictRepository districtRepository;

    public void checkIfCustomerExist(UUID id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            throw new BusinessException("Müşteri Bulunamadı");
        }
    }


}
