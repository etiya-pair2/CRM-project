package com.etiya.productservice.service.concretes;

import com.etiya.productservice.dto.offer.*;
import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.mapper.OfferMapper;
import com.etiya.productservice.repository.OfferRepository;
import com.etiya.productservice.service.abstracts.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    OfferMapper offerMapper = OfferMapper.INSTANCE;
    @Override
    public List<GetAllOfferResponse> getAll() {
        List<Offer> offers = offerRepository.findAll();
        return offerMapper.offerFromGetAllResponse(offers);
    }

    @Override
    public GetByIdOfferResponse getById(UUID id) {
        Optional<Offer> offer = offerRepository.findById(id);
        return offer.map(value -> offerMapper.offerFromGetByIdResponse(value)).orElse(null);    }

    @Override
    public CreateOfferResponse create(CreateOfferRequest request) {
        Offer offer = offerMapper.offerFromCreateRequest(request);
        offer.setCreatedDate(new Date());
        offer.setStatus(true);
        offerRepository.save(offer);
        return offerMapper.offerFromCreateResponse(offer);
    }

    @Override
    public UpdateOfferResponse update(UpdateOfferRequest request) {
        Offer oldOffer = offerRepository.findById(request.getId()).orElseThrow();
        Offer newOffer = offerMapper.offerFromUpdateRequest(request);
        newOffer.setCreatedDate(oldOffer.getCreatedDate());
        offerRepository.save(newOffer);
        return offerMapper.offerFromUpdateResponse(newOffer);
    }

    @Override
    public DeleteOfferResponse delete(UUID id) {
        Offer offer = offerRepository.findById(id).orElseThrow();
        offerRepository.delete(offer);
        return offerMapper.offerFromDeleteResponse(offer);
    }

    @Override
    public Offer findById(UUID id) {
        Optional<Offer> offer= offerRepository.findById(id);
        if(offer.isPresent())
            return offerRepository.findById(id).orElseThrow();
        return null;
    }
}
