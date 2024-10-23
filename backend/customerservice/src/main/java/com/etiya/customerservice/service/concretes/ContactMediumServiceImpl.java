package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.contactMedium.*;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.mapper.ContactMediumMapper;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepository contactMediumRepository;
    @Override
    public CreateContactMediumResponse create(CreateContactMediumRequest request) {
        ContactMedium contactMedium= ContactMediumMapper.INSTANCE.contactMediumFromCreateRequest(request);
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.contactMediumFromCreateResponse(contactMedium);
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest request) {
        ContactMedium contactMedium= ContactMediumMapper.INSTANCE.contactMediumFromUpdateRequest(request);
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.contactMediumFromUpdateResponse(contactMedium);
    }

    @Override
    public DeleteContactMediumResponse delete(UUID id) {
        ContactMedium contactMedium= contactMediumRepository.findById(id).orElseThrow(()->
                new RuntimeException("Contact Medium not found with ID:"  + id));
        return ContactMediumMapper.INSTANCE.contactMediumFromDeleteResponse(contactMedium);
    }

    @Override
    public List<GetAllContactMediumResponse> getAll() {
        List<ContactMedium> contactMediumList= contactMediumRepository.findAll();
        return ContactMediumMapper.INSTANCE.contactMediumFromGetAllResponse(contactMediumList);
    }

    @Override
    public GetByIdContactMediumResponse getById(UUID id) {
        ContactMedium contactMedium= contactMediumRepository.findById(id).orElseThrow(()->
                new RuntimeException("Contact Medium not found with ID:"  + id));
        return ContactMediumMapper.INSTANCE.getContactMediumById(contactMedium);
    }
}
