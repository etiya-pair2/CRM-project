package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.rules.IndCustBusinessRules;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {


    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndCustBusinessRules indCustBusinessRules;

    @Override
    public CreateIndividualCustomerResponse create(CreateIndividualCustomerRequest request) {
        indCustBusinessRules.checkMernis(request);
        IndividualCustomer individualCustomer= IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateRequest(request);
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.individualCustomerFromCreateResponse(individualCustomer);

    }

    @Override
    public UpdateIndividualCustomerResponse update(UpdateIndividualCustomerRequest request) {
        IndividualCustomer individualCustomer=
                IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateRequest(request);
        individualCustomerRepository.save(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.individualCustomerFromUpdateResponse(individualCustomer);
    }

    @Override
    public DeleteIndividualCustomerResponse delete(UUID customerId) {
        IndividualCustomer individualCustomer= (IndividualCustomer) individualCustomerRepository.findById(customerId).orElseThrow(() ->
                new RuntimeException("Customer not found with ID: " + customerId));
        individualCustomerRepository.delete(individualCustomer);
        return IndividualCustomerMapper.INSTANCE.individualCustomerFromDeleteResponse(individualCustomer);
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> individualCustomers= individualCustomerRepository.findAll();
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponseList= new ArrayList<>();
        for(IndividualCustomer individualCustomer:individualCustomers){
            getAllIndividualCustomerResponseList.add(IndividualCustomerMapper.INSTANCE.individualCustomerFromGetAllResponse(individualCustomer));
        }
        return getAllIndividualCustomerResponseList;
    }

    @Override
    public GetByIdIndividualCustomerResponse getById(UUID customerId) {
        IndividualCustomer individualCustomer= (IndividualCustomer) individualCustomerRepository.findById(customerId).orElseThrow(() ->
                new RuntimeException("Customer not found with ID: " + customerId));
        return IndividualCustomerMapper.INSTANCE.getIndividualCustomerById(individualCustomer);
    }

    @Override
    public List<GetAllIndividualCustomerResponse> searchCustomer(SearchIndCustomerRequest request) {
        List<IndividualCustomer> individualCustomers=individualCustomerRepository.searchIndividualCustomer(request);
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponseList= new ArrayList<>();
        for(IndividualCustomer individualCustomer:individualCustomers){
            getAllIndividualCustomerResponseList.add(IndividualCustomerMapper.INSTANCE.individualCustomerFromGetAllResponse(individualCustomer));
        }
        return getAllIndividualCustomerResponseList;
    }
}
