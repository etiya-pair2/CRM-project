package com.etiya.productservice.service.abstracts;

import com.etiya.productservice.dto.offer.*;
import com.etiya.productservice.entity.Offer;

import java.util.List;
import java.util.UUID;

public interface OfferService {
    List<GetAllOfferResponse> getAll();
    GetByIdOfferResponse getById(UUID id);
    CreateOfferResponse create(CreateOfferRequest request);
    UpdateOfferResponse update(UpdateOfferRequest request);
    DeleteOfferResponse delete(UUID id);
    Offer findById(UUID id);
}
