package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.category.*;

import java.util.List;
import java.util.UUID;

public interface AttributeService {

    List<GetAllAttributeResponse> getAll();
    GetByIdAttributeResponse getById(UUID id);
    CreateAttributeResponse create(CreateAttributeRequest request);
    UpdateAttributeResponse update(UpdateAttributeRequest request);
    DeleteAttributeResponse delete(UUID id);

}
