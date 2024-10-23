package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.dto.contactMedium.CreateContactMediumRequest;
import com.etiya.customerservice.dto.customer.CreateCustomerRequest;
import com.etiya.customerservice.dto.customer.CreateCustomerResponse;
import com.etiya.customerservice.dto.customer.DeleteCustomerResponse;
import com.etiya.customerservice.dto.customer.GetAllCustomerResponse;
import com.etiya.customerservice.dto.customer.GetByIdCustomerResponse;
import com.etiya.customerservice.dto.customer.UpdateCustomerRequest;
import com.etiya.customerservice.dto.customer.UpdateCustomerResponse;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.BillingAccount;
import com.etiya.customerservice.entity.ContactMedium;
import com.etiya.customerservice.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CreateCustomerResponse customerFromCreateResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CreateCustomerResponse createCustomerResponse = new CreateCustomerResponse();

        createCustomerResponse.setId( customer.getId() );
        createCustomerResponse.setCreatedDate( customer.getCreatedDate() );
        createCustomerResponse.setUpdatedDate( customer.getUpdatedDate() );
        createCustomerResponse.setStatus( customer.isStatus() );
        createCustomerResponse.setContactMediumList( contactMediumListToCreateContactMediumRequestList( customer.getContactMediumList() ) );
        createCustomerResponse.setAddressList( addressListToCreateAddressRequestList( customer.getAddressList() ) );
        createCustomerResponse.setBillingAccountList( billingAccountListToCreateBillingAccountRequestList( customer.getBillingAccountList() ) );

        return createCustomerResponse;
    }

    @Override
    public UpdateCustomerResponse customerFromUpdateResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        UpdateCustomerResponse updateCustomerResponse = new UpdateCustomerResponse();

        updateCustomerResponse.setId( customer.getId() );
        updateCustomerResponse.setUpdatedDate( customer.getUpdatedDate() );
        updateCustomerResponse.setStatus( customer.isStatus() );

        return updateCustomerResponse;
    }

    @Override
    public DeleteCustomerResponse customerFromDeleteResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        DeleteCustomerResponse deleteCustomerResponse = new DeleteCustomerResponse();

        deleteCustomerResponse.setId( customer.getId() );
        deleteCustomerResponse.setStatus( customer.isStatus() );

        return deleteCustomerResponse;
    }

    @Override
    public List<GetAllCustomerResponse> customerFromGetAllResponse(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<GetAllCustomerResponse> list = new ArrayList<GetAllCustomerResponse>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( customerToGetAllCustomerResponse( customer ) );
        }

        return list;
    }

    @Override
    public GetByIdCustomerResponse getCustomerById(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        GetByIdCustomerResponse getByIdCustomerResponse = new GetByIdCustomerResponse();

        getByIdCustomerResponse.setId( customer.getId() );
        getByIdCustomerResponse.setCreatedDate( customer.getCreatedDate() );
        getByIdCustomerResponse.setUpdatedDate( customer.getUpdatedDate() );
        getByIdCustomerResponse.setStatus( customer.isStatus() );

        return getByIdCustomerResponse;
    }

    @Override
    public Customer customerFromCreateRequest(CreateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setCreatedDate( request.getCreatedDate() );
        customer.setUpdatedDate( request.getUpdatedDate() );
        customer.setStatus( request.isStatus() );

        return customer;
    }

    @Override
    public Customer customerFromUpdateRequest(UpdateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( request.getId() );
        customer.setUpdatedDate( request.getUpdatedDate() );
        customer.setStatus( request.isStatus() );

        return customer;
    }

    protected CreateContactMediumRequest contactMediumToCreateContactMediumRequest(ContactMedium contactMedium) {
        if ( contactMedium == null ) {
            return null;
        }

        CreateContactMediumRequest createContactMediumRequest = new CreateContactMediumRequest();

        createContactMediumRequest.setEmail( contactMedium.getEmail() );
        createContactMediumRequest.setHomePhone( contactMedium.getHomePhone() );
        createContactMediumRequest.setMobilePhone( contactMedium.getMobilePhone() );
        createContactMediumRequest.setFax( contactMedium.getFax() );

        return createContactMediumRequest;
    }

    protected List<CreateContactMediumRequest> contactMediumListToCreateContactMediumRequestList(List<ContactMedium> list) {
        if ( list == null ) {
            return null;
        }

        List<CreateContactMediumRequest> list1 = new ArrayList<CreateContactMediumRequest>( list.size() );
        for ( ContactMedium contactMedium : list ) {
            list1.add( contactMediumToCreateContactMediumRequest( contactMedium ) );
        }

        return list1;
    }

    protected CreateAddressRequest addressToCreateAddressRequest(Address address) {
        if ( address == null ) {
            return null;
        }

        CreateAddressRequest createAddressRequest = new CreateAddressRequest();

        createAddressRequest.setPostalCode( address.getPostalCode() );
        createAddressRequest.setDescription( address.getDescription() );
        createAddressRequest.setFlatNumber( address.getFlatNumber() );

        return createAddressRequest;
    }

    protected List<CreateAddressRequest> addressListToCreateAddressRequestList(List<Address> list) {
        if ( list == null ) {
            return null;
        }

        List<CreateAddressRequest> list1 = new ArrayList<CreateAddressRequest>( list.size() );
        for ( Address address : list ) {
            list1.add( addressToCreateAddressRequest( address ) );
        }

        return list1;
    }

    protected CreateBillingAccountRequest billingAccountToCreateBillingAccountRequest(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        CreateBillingAccountRequest createBillingAccountRequest = new CreateBillingAccountRequest();

        createBillingAccountRequest.setAddress( billingAccount.getAddress() );
        createBillingAccountRequest.setDescription( billingAccount.getDescription() );
        createBillingAccountRequest.setAccountName( billingAccount.getAccountName() );
        createBillingAccountRequest.setAccountNumber( billingAccount.getAccountNumber() );
        createBillingAccountRequest.setAccountStatus( billingAccount.getAccountStatus() );
        createBillingAccountRequest.setAccountType( billingAccount.getAccountType() );

        return createBillingAccountRequest;
    }

    protected List<CreateBillingAccountRequest> billingAccountListToCreateBillingAccountRequestList(List<BillingAccount> list) {
        if ( list == null ) {
            return null;
        }

        List<CreateBillingAccountRequest> list1 = new ArrayList<CreateBillingAccountRequest>( list.size() );
        for ( BillingAccount billingAccount : list ) {
            list1.add( billingAccountToCreateBillingAccountRequest( billingAccount ) );
        }

        return list1;
    }

    protected GetAllCustomerResponse customerToGetAllCustomerResponse(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        GetAllCustomerResponse getAllCustomerResponse = new GetAllCustomerResponse();

        getAllCustomerResponse.setId( customer.getId() );
        getAllCustomerResponse.setCreatedDate( customer.getCreatedDate() );
        getAllCustomerResponse.setUpdatedDate( customer.getUpdatedDate() );
        getAllCustomerResponse.setStatus( customer.isStatus() );

        return getAllCustomerResponse;
    }
}
