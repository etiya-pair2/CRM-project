package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.corporateCustomer.*;
import com.etiya.customerservice.entity.CorporateCustomer;
import com.etiya.customerservice.mapper.CorporateCustomerMapper;
import com.etiya.customerservice.repository.CorporateCustomerRepository;
import com.etiya.customerservice.service.abstracts.CorporateCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CorporateCustomerServiceImpl implements CorporateCustomerService {

    private final CorporateCustomerRepository corporateCustomerRepository;
    @Override
    public CreateCorporateCustomerResponse create(CreateCorporateCustomerRequest request) {
        CorporateCustomer corporateCustomer= CorporateCustomerMapper.INSTANCE.corporateCustomerFromCreateRequest(request);
        corporateCustomerRepository.save(corporateCustomer);
        return CorporateCustomerMapper.INSTANCE.corporateCustomerFromCreateResponse(corporateCustomer);
    }

    @Override
    public UpdateCorporateCustomerResponse update(UpdateCorporateCustomerRequest request) {
        CorporateCustomer corporateCustomer=
                CorporateCustomerMapper.INSTANCE.corporateCustomerFromUpdateRequest(request);
        corporateCustomerRepository.save(corporateCustomer);
        return CorporateCustomerMapper.INSTANCE.corporateCustomerFromUpdateResponse(corporateCustomer);
    }

    @Override
    public DeleteCorporateCustomerResponse delete(UUID id) {
        CorporateCustomer corporateCustomer= corporateCustomerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found with ID:"  + id));
        return CorporateCustomerMapper.INSTANCE.corporateCustomerFromDeleteResponse(corporateCustomer);
    }

    @Override
    public List<GetAllCorporateCustomerResponse> getAll() {
        List<CorporateCustomer> corporateCustomers=corporateCustomerRepository.findAll();
        List<GetAllCorporateCustomerResponse> getAllCorporateCustomerResponseList= new ArrayList<>();
        for(CorporateCustomer corporateCustomer:corporateCustomers){
            getAllCorporateCustomerResponseList.add(CorporateCustomerMapper.INSTANCE.corporateCustomerFromGetAllResponse(corporateCustomer));
        }
        return getAllCorporateCustomerResponseList;
    }

    @Override
    public GetByIdCorporateCustomerResponse getById(UUID id) {
        CorporateCustomer corporateCustomer= corporateCustomerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found with ID:"  + id));
        return CorporateCustomerMapper.INSTANCE.getCustomerById(corporateCustomer);
    }
}
