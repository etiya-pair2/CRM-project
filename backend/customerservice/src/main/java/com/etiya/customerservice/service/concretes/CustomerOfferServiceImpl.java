package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.client.ProductServiceClient;
import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferRequest;
import com.etiya.customerservice.dto.customerOffer.CreateCustomerOfferResponse;
import com.etiya.customerservice.entity.CustomerOffer;
import com.etiya.customerservice.entity.Offer;
import com.etiya.customerservice.mapper.CustomerOfferMapper;
import com.etiya.customerservice.repository.CustomerOfferRepository;
import com.etiya.customerservice.service.abstracts.CustomerOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerOfferServiceImpl implements CustomerOfferService {

    private final CustomerOfferRepository repository;
    private final ProductServiceClient productServiceClient;

    CustomerOfferMapper mapper = CustomerOfferMapper.INSTANCE;
    @Override
    public CreateCustomerOfferResponse create(CreateCustomerOfferRequest request) {
        Offer offer =  productServiceClient.findById(request.getOfferId());
        if(offer!=null){
            CustomerOffer customerOffer = repository.save(mapper.customerOfferFromCreateRequest(request));
            return mapper.customerOfferFromCreateResponse(customerOffer);
        }
        return null;
    }
}
