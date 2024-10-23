package com.etiya.customerservice.service.abstracts;

import com.etiya.customerservice.dto.contactMedium.*;


import java.util.List;
import java.util.UUID;

public interface ContactMediumService {
    CreateContactMediumResponse create(CreateContactMediumRequest request);
    UpdateContactMediumResponse update(UpdateContactMediumRequest request);
    DeleteContactMediumResponse delete(UUID id);
    List<GetAllContactMediumResponse> getAll();
    GetByIdContactMediumResponse getById(UUID id);
}
