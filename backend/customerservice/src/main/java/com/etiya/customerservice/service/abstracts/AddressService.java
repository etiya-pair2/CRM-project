package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.address.*;

import java.util.List;
import java.util.UUID;

public interface AddressService {
    CreateAddressResponse create (CreateAddressRequest request);

    UpdateAddressResponse update (UpdateAddressRequest request);

    DeleteAddressResponse delete(UUID id);

    List<GetAllAddressResponse> getAll();

    GetByIdAddressResponse getById(UUID id);
}
