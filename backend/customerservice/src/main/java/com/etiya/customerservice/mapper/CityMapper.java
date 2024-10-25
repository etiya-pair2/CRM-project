package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.city.*;
import com.etiya.customerservice.dto.customer.*;
import com.etiya.customerservice.entity.City;
import com.etiya.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CityMapper {
    CityMapper INSTANCE= Mappers.getMapper(CityMapper.class);

    CreateCityResponse cityFromCreateResponse( City city);

    UpdateCityResponse cityFromUpdateResponse( City city);
    DeleteCityResponse cityFromDeleteResponse(City city);

    GetAllCityResponse cityFromGetAllResponse(City cities);

    GetByIdCityResponse getCityById(City city);

    City cityFromCreateRequest(CreateCityRequest request);

    City cityFromUpdateRequest(UpdateCityRequest request);
}
