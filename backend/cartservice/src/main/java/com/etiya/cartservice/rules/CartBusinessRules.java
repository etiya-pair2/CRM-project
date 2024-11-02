package com.etiya.cartservice.rules;

import com.etiya.cartservice.client.CustomerServiceClient;
import com.etiya.cartservice.entity.IndividualCustomer;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CartBusinessRules {

    private final CustomerServiceClient customerServiceClient;

    //gereksiz olmuş olabilir
    public void existByCustomer(UUID customerId){
        IndividualCustomer individualCustomer = customerServiceClient.findById(customerId);
        if (individualCustomer == null)
            throw new BusinessException("Customer Bulunamadı");
    }
}
