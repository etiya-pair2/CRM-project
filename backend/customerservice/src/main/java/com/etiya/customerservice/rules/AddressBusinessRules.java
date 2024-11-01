package com.etiya.customerservice.rules;

import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.repository.DistrictRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class AddressBusinessRules {

    private final CustomerRepository customerRepository;

    private final DistrictRepository districtRepository;

    private final AddressRepository addressRepository;

    public Address checkIfAddressExist(UUID id) {
        return addressRepository.findById(id).orElseThrow(() ->  new BusinessException("Adres Bulunamadı"));
    }

    public void checkIfCustomerExist(UUID id) {
        customerRepository.findById(id).orElseThrow(() -> new BusinessException("Müşteri Bulunamadı"));
    }

    public void checkIfDistrictExist(UUID id) {
        districtRepository.findById(id).orElseThrow(() -> new BusinessException("Bölge Bulunamadı"));
    }


}
