package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.mapper.AddressMapper;
import com.etiya.customerservice.repository.AddressRepository;
import com.etiya.customerservice.service.abstracts.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public CreateAddressResponse create(CreateAddressRequest request) {
        Address address= AddressMapper.INSTANCE.addressFromCreateRequest(request);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.addressFromCreateResponse(address);
    }

    @Override
    public UpdateAddressResponse update(UpdateAddressRequest request) {
        Address address= AddressMapper.INSTANCE.addressFromUpdateRequest(request);
        addressRepository.save(address);
        return AddressMapper.INSTANCE.addressFromUpdateResponse(address);
    }

    @Override
    public DeleteAddressResponse delete(UUID id) {
        Address address= addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found with ID:"  + id));
        return AddressMapper.INSTANCE.addressFromDeleteResponse(address);
    }

    @Override
    public List<GetAllAddressResponse> getAll() {
        List<Address> addresses= addressRepository.findAll();
        return AddressMapper.INSTANCE.addressFromGetAllResponse(addresses);
    }

    @Override
    public GetByIdAddressResponse getById(UUID id) {
        Address address= addressRepository.findById(id).orElseThrow(()->
                new RuntimeException("Address not found with ID:"  + id));
        return AddressMapper.INSTANCE.getAddressById(address);
    }
}
