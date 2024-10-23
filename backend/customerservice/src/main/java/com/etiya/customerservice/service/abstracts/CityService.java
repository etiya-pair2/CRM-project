package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.city.*;

import java.util.List;
import java.util.UUID;

public interface CityService {

    CreateCityResponse create(CreateCityRequest request);

    UpdateCityResponse update(UpdateCityRequest request);

    DeleteCityResponse delete(UUID id);

    List<GetAllCityResponse> getAll();

    GetByIdCityResponse getById (UUID id);
}
