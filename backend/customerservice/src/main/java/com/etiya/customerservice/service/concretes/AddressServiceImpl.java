package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.mapper.AddressMapper;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.rules.AddressBusinessRules;
import com.etiya.customerservice.service.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    private final AddressBusinessRules addressBusinessRules;

    @Override
    public CreateAddressResponse create(CreateAddressRequest request) {
        addressBusinessRules.checkIfCustomerExist(request.getCustomerId());
        addressBusinessRules.checkIfDistrictExist(request.getDistrictId());
        Address address= AddressMapper.INSTANCE.addressFromCreateRequest(request);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.addressFromCreateResponse(address);
    }

    @Override
    public UpdateAddressResponse update(UpdateAddressRequest request) {
        addressBusinessRules.checkIfAddressExist(request.getId());
        addressBusinessRules.checkIfCustomerExist(request.getCustomerId());
        addressBusinessRules.checkIfDistrictExist(request.getDistrictId());
        Address address= AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.addressFromUpdateResponse(address);
    }

    @Override
    public DeleteAddressResponse delete(UUID id) {
        Address address = addressBusinessRules.checkIfAddressExist(id);
        return AddressMapper.INSTANCE.addressFromDeleteResponse(address);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
        List<Address> addresses= addressRepository.findAll();
        List<GetAllAddressResponse> getAllAddressResponseList = new ArrayList<>();
        for(Address address: addresses){
            getAllAddressResponseList.add(AddressMapper.INSTANCE.addressFromGetAllResponse(address));
        }
        return getAllAddressResponseList;
    }

    @Override
    public GetByIdAddressResponse getById(UUID id) {
        Address address = addressBusinessRules.checkIfAddressExist(id);
        return AddressMapper.INSTANCE.getAddressById(address);
    }
}
