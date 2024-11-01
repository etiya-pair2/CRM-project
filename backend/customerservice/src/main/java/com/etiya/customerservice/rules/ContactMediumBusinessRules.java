package com.etiya.customerservice.rules;


import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.repository.CustomerRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ContactMediumBusinessRules {

    private final CustomerRepository customerRepository;
    private final ContactMediumRepository contactMediumRepository;

    public ContactMedium checkIfContMedExist(UUID id) {
        return contactMediumRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Contact medium bulunamadı."));
    }
    public void checkIfCustomerExist(UUID id){
        customerRepository.findById(id).orElseThrow(() -> new BusinessException("Müşteri Bulunamadı"));
    }

}
