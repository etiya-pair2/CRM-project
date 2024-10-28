package com.etiya.customerservice.service.concretes;


import com.etiya.customerservice.dto.city.*;
import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.mapper.CityMapper;
import com.etiya.customerservice.repository.CityRepository;
import com.etiya.customerservice.rules.CityBusinessRules;
import com.etiya.customerservice.service.abstracts.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {


    private final  CityRepository cityRepository;
    private final CityBusinessRules cityBusinessRules;
    @Override
    public CreateCityResponse create(CreateCityRequest request) {
        cityBusinessRules.checkIfCityNameExists(request.getName());
        City city = CityMapper.INSTANCE.cityFromCreateRequest(request);
        cityRepository.save(city);
        return CityMapper.INSTANCE.cityFromCreateResponse(city);
    }

    @Override
    public UpdateCityResponse update(UpdateCityRequest request) {
        cityBusinessRules.checkIfCityExist(request.getId());
        cityBusinessRules.checkIfCityNameExists(request.getName());
        City city = CityMapper.INSTANCE.cityFromUpdateRequest(request);
        cityRepository.save(city);
        return CityMapper.INSTANCE.cityFromUpdateResponse(city);
    }

    @Override
    public DeleteCityResponse delete(UUID id) {
        City city = cityBusinessRules.checkIfCityExist(id);
        return CityMapper.INSTANCE.cityFromDeleteResponse(city);
    }

    @Override
    public List<GetAllCityResponse> getAll() {
        List<City> cities = cityRepository.findAll();
        List<GetAllCityResponse> getAllCityResponseList= new ArrayList<>();
        for(City city: cities){
            getAllCityResponseList.add(CityMapper.INSTANCE.cityFromGetAllResponse(city));
        }
        return getAllCityResponseList;
    }

    @Override
    public GetByIdCityResponse getById(UUID id) {
        City city = cityBusinessRules.checkIfCityExist(id);
        return CityMapper.INSTANCE.getCityById(city);
    }
}
