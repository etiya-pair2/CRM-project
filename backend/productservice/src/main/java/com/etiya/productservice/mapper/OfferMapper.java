package com.etiya.productservice.mapper;

import com.etiya.productservice.dto.offer.*;
import com.etiya.productservice.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OfferMapper {

    OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);

    Offer offerFromCreateRequest(CreateOfferRequest request);

    CreateOfferResponse offerFromCreateResponse (Offer offer);

    Offer offerFromUpdateRequest(UpdateOfferRequest request);

    UpdateOfferResponse offerFromUpdateResponse(Offer offer);

    List<GetAllOfferResponse> offerFromGetAllResponse(List<Offer> offers);

    GetByIdOfferResponse offerFromGetByIdResponse(Offer offer);

    DeleteOfferResponse offerFromDeleteResponse(Offer offer);

}
