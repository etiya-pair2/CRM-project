package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.customer.*;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.IndividualCustomer;
import com.etiya.customerservice.mapper.CustomerMapper;
import com.etiya.customerservice.mapper.IndividualCustomerMapper;
import com.etiya.customerservice.repository.CustomerRepository;
import com.etiya.customerservice.service.abstracts.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    @Override
    public CreateCustomerResponse create(CreateCustomerRequest request) {
        Customer customer= CustomerMapper.INSTANCE.customerFromCreateRequest(request);
        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerFromCreateResponse(customer);
    }

    @Override
    public UpdateCustomerResponse update(UpdateCustomerRequest request) {
        Customer customer= CustomerMapper.INSTANCE.customerFromUpdateRequest(request);
        customerRepository.save(customer);
        return CustomerMapper.INSTANCE.customerFromUpdateResponse(customer);
    }

    @Override
    public DeleteCustomerResponse delete(UUID id) {
        Customer customer= (Customer )customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found with ID:"  + id));
        return CustomerMapper.INSTANCE.customerFromDeleteResponse(customer);
    }

    @Override
    public List<GetAllCustomerResponse> getAll() {
        List<Customer> customers= customerRepository.findAll();
        List<GetAllCustomerResponse> getAllCustomerResponseList=new ArrayList<>();
        for(Customer customer: customers){
            getAllCustomerResponseList.add(CustomerMapper.INSTANCE.customerFromGetAllResponse(customer));
        }
        return getAllCustomerResponseList;

    }

    @Override
    public GetByIdCustomerResponse getById(UUID id) {
        Customer customer= (Customer )customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Customer not found with ID:"  + id));
        return CustomerMapper.INSTANCE.getCustomerById(customer);
    }
}
