package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.DeleteContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.GetAllContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.GetByIdContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.dto.contactMedium.UpdateContactMediumResponse;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class ContactMediumMapperImpl implements ContactMediumMapper {

    @Override
    public CreateContactMediumResponse contactMediumFromCreateResponse(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        CreateContactMediumResponse createContactMediumResponse = new CreateContactMediumResponse();

        createContactMediumResponse.setCustomerId( contactMediumCustomerId( contactMedium ) );
        createContactMediumResponse.setId( contactMedium.getId() );
        createContactMediumResponse.setEmail( contactMedium.getEmail() );
        createContactMediumResponse.setHomePhone( contactMedium.getHomePhone() );
        createContactMediumResponse.setMobilePhone( contactMedium.getMobilePhone() );
        createContactMediumResponse.setFax( contactMedium.getFax() );

        return createContactMediumResponse;
    }

    @Override
    public UpdateContactMediumResponse contactMediumFromUpdateResponse(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        UpdateContactMediumResponse updateContactMediumResponse = new UpdateContactMediumResponse();

        updateContactMediumResponse.setCustomerId( contactMediumCustomerId( contactMedium ) );
        updateContactMediumResponse.setEmail( contactMedium.getEmail() );
        updateContactMediumResponse.setHomePhone( contactMedium.getHomePhone() );
        updateContactMediumResponse.setMobilePhone( contactMedium.getMobilePhone() );
        updateContactMediumResponse.setFax( contactMedium.getFax() );

        return updateContactMediumResponse;
    }

    @Override
    public DeleteContactMediumResponse contactMediumFromDeleteResponse(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        DeleteContactMediumResponse deleteContactMediumResponse = new DeleteContactMediumResponse();

        deleteContactMediumResponse.setCustomerId( contactMediumCustomerId( contactMedium ) );
        deleteContactMediumResponse.setId( contactMedium.getId() );

        return deleteContactMediumResponse;
    }

    @Override
    public List<GetAllContactMediumResponse> contactMediumFromGetAllResponse(List<ContactMedium> contactMediums) {
        if ( contactMediums == null ) {
            return null;
        }

        List<GetAllContactMediumResponse> list = new ArrayList<GetAllContactMediumResponse>( contactMediums.size() );
        for ( ContactMedium contactMedium : contactMediums ) {
            list.add( contactMediumToGetAllContactMediumResponse( contactMedium ) );
        }

        return list;
    }

    @Override
    public GetByIdContactMediumResponse getContactMediumById(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        GetByIdContactMediumResponse getByIdContactMediumResponse = new GetByIdContactMediumResponse();

        getByIdContactMediumResponse.setCustomerId( contactMediumCustomerId( contactMedium ) );
        getByIdContactMediumResponse.setEmail( contactMedium.getEmail() );
        getByIdContactMediumResponse.setHomePhone( contactMedium.getHomePhone() );
        getByIdContactMediumResponse.setMobilePhone( contactMedium.getMobilePhone() );
        getByIdContactMediumResponse.setFax( contactMedium.getFax() );

        return getByIdContactMediumResponse;
    }

    @Override
    public ContactMedium contactMediumFromCreateRequest(CreateContactMediumRequest request) {
        if ( request == null ) {
            return null;
        }

        ContactMedium contactMedium = new ContactMedium();

        contactMedium.setCustomer( createContactMediumRequestToCustomer( request ) );
        contactMedium.setEmail( request.getEmail() );
        contactMedium.setHomePhone( request.getHomePhone() );
        contactMedium.setMobilePhone( request.getMobilePhone() );
        contactMedium.setFax( request.getFax() );

        return contactMedium;
    }

    @Override
    public ContactMedium contactMediumFromUpdateRequest(UpdateContactMediumRequest request) {
        if ( request == null ) {
            return null;
        }

        ContactMedium contactMedium = new ContactMedium();

        contactMedium.setCustomer( updateContactMediumRequestToCustomer( request ) );
        contactMedium.setEmail( request.getEmail() );
        contactMedium.setHomePhone( request.getHomePhone() );
        contactMedium.setMobilePhone( request.getMobilePhone() );
        contactMedium.setFax( request.getFax() );

        return contactMedium;
    }

    private UUID contactMediumCustomerId(ContactMedium contactMedium) {
        Customer customer = contactMedium.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getId();
    }

    protected GetAllContactMediumResponse contactMediumToGetAllContactMediumResponse(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        GetAllContactMediumResponse getAllContactMediumResponse = new GetAllContactMediumResponse();

        getAllContactMediumResponse.setId( contactMedium.getId() );
        getAllContactMediumResponse.setEmail( contactMedium.getEmail() );
        getAllContactMediumResponse.setHomePhone( contactMedium.getHomePhone() );
        getAllContactMediumResponse.setMobilePhone( contactMedium.getMobilePhone() );
        getAllContactMediumResponse.setFax( contactMedium.getFax() );

        return getAllContactMediumResponse;
    }

    protected Customer createContactMediumRequestToCustomer(CreateContactMediumRequest createContactMediumRequest) {
        if ( createContactMediumRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( createContactMediumRequest.getCustomerId() );

        return customer;
    }

    protected Customer updateContactMediumRequestToCustomer(UpdateContactMediumRequest updateContactMediumRequest) {
        if ( updateContactMediumRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( updateContactMediumRequest.getCustomerId() );

        return customer;
    }
}
