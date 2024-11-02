package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.district.*;

import java.util.List;
import java.util.UUID;

public interface DistrictService {

    CreateDistrictResponse create(CreateDistrictRequest request);

    UpdateDistrictResponse update(UpdateDistrictRequest request);

    DeleteDistrictResponse delete(UUID id);

    List<GetAllDistrictResponse> getAll();

    GetByIdDistrictResponse getById(UUID id);

    List<GetByCityIdDistrictResponse> getDistrictsFromCity(UUID id);
}
