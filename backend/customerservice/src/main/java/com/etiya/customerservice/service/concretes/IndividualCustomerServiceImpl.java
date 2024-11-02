package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.IndividualCustomerRepository;
import com.etiya.customerservice.rules.IndCustBusinessRules;
import com.etiya.customerservice.service.abstracts.IndividualCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class IndividualCustomerServiceImpl implements IndividualCustomerService {


    private final IndividualCustomerRepository individualCustomerRepository;
    private final IndCustBusinessRules indCustBusinessRules;

    IndividualCustomerMapper indCustMapper =  IndividualCustomerMapper.INSTANCE;

    @Override
    public CreateIndividualCustomerResponse create(CreateIndividualCustomerRequest request) {
        indCustBusinessRules.checkMernis(request);
        indCustBusinessRules.checkIndCustExist(request.getNationalityId());
        IndividualCustomer individualCustomer= indCustMapper.individualCustomerFromCreateRequest(request);
        individualCustomer.setStatus(true);
        return indCustMapper.individualCustomerFromCreateResponse(individualCustomerRepository.save(individualCustomer));

    }

    @Override
    public UpdateIndividualCustomerResponse update(UpdateIndividualCustomerRequest request) {
        IndividualCustomer indCustCredentials = indCustBusinessRules.checkCustomerExist(request.getCustomerId());
        IndividualCustomer individualCustomer = indCustMapper.individualCustomerFromUpdateRequest(request);
        individualCustomer.setNationalityId(indCustCredentials.getNationalityId());
        individualCustomer.setBirthday(indCustCredentials.getBirthday());
        individualCustomer.setFirstName(indCustCredentials.getFirstName());
        individualCustomer.setLastName(indCustCredentials.getLastName());
        individualCustomer.setMiddleName(indCustCredentials.getMiddleName());

        individualCustomerRepository.save(individualCustomer);
        return indCustMapper.individualCustomerFromUpdateResponse(individualCustomer);
    }

    @Override
    public DeleteIndividualCustomerResponse delete(UUID customerId) {
        IndividualCustomer individualCustomer= indCustBusinessRules.checkCustomerExist(customerId);
        indCustBusinessRules.checkDeletedCustExist(customerId);
        individualCustomer.setStatus(false);
        individualCustomer.setNationalityId("");
        individualCustomerRepository.save(individualCustomer);
        return indCustMapper.individualCustomerFromDeleteResponse(individualCustomer);
    }

    @Override
    public List<GetAllIndividualCustomerResponse> getAll() {
        List<IndividualCustomer> individualCustomers= individualCustomerRepository.findAll();
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponseList= new ArrayList<>();
        for(IndividualCustomer individualCustomer:individualCustomers){
            getAllIndividualCustomerResponseList.add(indCustMapper.individualCustomerFromGetAllResponse(individualCustomer));
        }
        return getAllIndividualCustomerResponseList;
    }

    @Override
    public GetByIdIndividualCustomerResponse getById(UUID customerId) {
        return indCustMapper.getIndividualCustomerById(indCustBusinessRules.checkCustomerExist(customerId));
    }

    @Override
    public List<GetAllIndividualCustomerResponse> searchCustomer(SearchIndCustomerRequest request) {
        List<IndividualCustomer> individualCustomers=individualCustomerRepository.searchIndividualCustomer(request);
        List<GetAllIndividualCustomerResponse> getAllIndividualCustomerResponseList= new ArrayList<>();
        for(IndividualCustomer individualCustomer:individualCustomers){
            getAllIndividualCustomerResponseList.add(indCustMapper.individualCustomerFromGetAllResponse(individualCustomer));
        }
        return getAllIndividualCustomerResponseList;
    }

    @Override
    public GetByIdIndividualCustomerResponse findById(UUID customerId) {
        Optional<IndividualCustomer> individualCustomer = individualCustomerRepository.findById(customerId);
        return individualCustomer.map(customer -> indCustMapper.getIndividualCustomerById(customer)).orElse(null);
    }
}
