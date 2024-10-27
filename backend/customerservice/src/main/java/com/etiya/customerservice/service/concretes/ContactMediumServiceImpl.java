package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.contactMedium.*;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.mapper.ContactMediumMapper;
import com.etiya.customerservice.repository.ContactMediumRepository;
import com.etiya.customerservice.rules.ContactMediumBusinessRules;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContactMediumServiceImpl implements ContactMediumService {

    private final ContactMediumRepository contactMediumRepository;
    private final ContactMediumBusinessRules contactMediumBusinessRules;
    @Override
    public CreateContactMediumResponse create(CreateContactMediumRequest request) {
        contactMediumBusinessRules.checkIfCustomerExist(request.getCustomerId());
        ContactMedium contactMedium= ContactMediumMapper.INSTANCE.contactMediumFromCreateRequest(request);
        contactMediumRepository.save(contactMedium);
        return ContactMediumMapper.INSTANCE.contactMediumFromCreateResponse(contactMedium);
    }

    @Override
    public UpdateContactMediumResponse update(UpdateContactMediumRequest request) {
        ContactMedium oldContactMedium = contactMediumBusinessRules.checkIfContMedExist(request.getId());
        ContactMedium newContactMedium= ContactMediumMapper.INSTANCE.contactMediumFromUpdateRequest(request);
        newContactMedium.setCustomer(oldContactMedium.getCustomer());
        contactMediumRepository.save(newContactMedium);
        return ContactMediumMapper.INSTANCE.contactMediumFromUpdateResponse(newContactMedium);
    }

    @Override
    public DeleteContactMediumResponse delete(UUID id) {
        return ContactMediumMapper.INSTANCE.contactMediumFromDeleteResponse(contactMediumBusinessRules.checkIfContMedExist(id));
    }

    @Override
    public List<GetAllContactMediumResponse> getAll() {
        List<ContactMedium> contactMediumList= contactMediumRepository.findAll();
        List<GetAllContactMediumResponse> getAllContactMediumResponseList=new ArrayList<>();
        for(ContactMedium contactMedium:contactMediumList){
            getAllContactMediumResponseList.add(ContactMediumMapper.INSTANCE.contactMediumFromGetAllResponse(contactMedium));
        }
        return getAllContactMediumResponseList;
    }

    @Override
    public GetByIdContactMediumResponse getById(UUID id) {
        return ContactMediumMapper.INSTANCE.getContactMediumById(contactMediumBusinessRules.checkIfContMedExist(id));
    }
}
