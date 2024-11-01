package com.etiya.customerservice.rules;

import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.repository.CityRepository;
import io.github.sabaurgup.exceptions.type.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CityBusinessRules {

    private final CityRepository cityRepository;

    public City checkIfCityExist(UUID id) {
        return cityRepository.findById(id).orElseThrow(() -> new BusinessException("Şehir Bulunamadı"));
    }
    public void checkIfCityNameExists(String name) {
        if (cityRepository.existsByName(name)) {
            throw new BusinessException("Bu isimle bir şehir zaten mevcut.");
        }
    }
}
