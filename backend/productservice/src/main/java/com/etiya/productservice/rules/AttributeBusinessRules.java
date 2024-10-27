//package com.etiya.productservice.rules;
//
//import com.etiya.productservice.controller.AttributeController;
//import com.etiya.productservice.entity.Attribute;
//import com.etiya.productservice.repository.AttributeRepository;
//import io.github.sabaurgup.exceptions.BusinessException;
//import io.github.sabaurgup.exceptions.Messages;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class AttributeBusinessRules {
//
//    private final AttributeRepository attributeRepository;
//
//    public void checkIfNameExist(String email) {
//        Optional<Attribute> userOptional = attributeRepository.findByNameIgnoreCase(email);
//        if (userOptional.isPresent()) {
//            throw new BusinessException(Messages.USER_EMAIL_ALREADY_EXISTS);
//        }
//}
