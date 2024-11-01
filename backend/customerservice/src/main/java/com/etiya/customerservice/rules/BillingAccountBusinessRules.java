package com.etiya.customerservice.rules;

import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.repository.BillingAccountRepository;
import com.etiya.customerservice.repository.CustomerRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BillingAccountBusinessRules {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;
    private final BillingAccountRepository billingAccountRepository;

    public void checkIfCustomerAddressExist(UUID customerId, UUID addressId) {
        List<Address> addresses = customerRepository.findById(customerId)
                .map(Customer::getAddressList)
                .orElseGet(ArrayList::new);

        boolean addressExists = addresses.stream()
                .anyMatch(address -> address.getId().equals(addressId));

        if (!addressExists) {
            throw new BusinessException("Müşterinin Adresi Bulunamadı");
        }
    }

    public void checkIfBilAccExistsForCustAndAddress(UUID customerId, UUID addressId) {
        boolean exists = billingAccountRepository.existsByCustomerIdAndAddressId(customerId, addressId);

        if (exists) {
            throw new BusinessException("Aynı müşteri ve adresle birden fazla fatura hesabı oluşturulamaz.");
        }
    }




    public void checkIfCustomerExist(UUID id) {
         customerRepository.findById(id).orElseThrow(() ->  new BusinessException("Müşteri Bulunamadı"));

    }

    public BillingAccount checkIfBilAccExist(UUID id) {
        return billingAccountRepository.findById(id).orElseThrow(() ->  new BusinessException("Fatura Hesabı Bulunamadı"));
    }


}
