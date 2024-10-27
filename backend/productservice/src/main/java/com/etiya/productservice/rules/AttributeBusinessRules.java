package com.etiya.productservice.rules;

import com.etiya.productservice.controller.AttributeController;
import com.etiya.productservice.core.configuration.exceptions.type.BusinessException;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.repository.AttributeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AttributeBusinessRules {

    private final AttributeRepository attributeRepository;

    public void checkIfNameExist(String email) {
        Optional<Attribute> userOptional = attributeRepository.findByNameIgnoreCase(email);
        if (userOptional.isPresent()) {
            throw new BusinessException("User Email Already Exist");
        }
    }
}
