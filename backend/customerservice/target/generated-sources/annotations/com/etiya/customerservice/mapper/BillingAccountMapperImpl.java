package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountRequest;
import com.etiya.customerservice.dto.billingAccount.CreateBillingAccountResponse;
import com.etiya.customerservice.dto.billingAccount.DeleteBillingAccountResponse;
import com.etiya.customerservice.dto.billingAccount.GetAllBillingAccountResponse;
import com.etiya.customerservice.dto.billingAccount.GetByIdBillingAccountResponse;
import com.etiya.customerservice.dto.billingAccount.UpdateBillingAccountRequest;
import com.etiya.customerservice.dto.billingAccount.UpdateBillingAccountResponse;
import com.etiya.customerservice.entity.BillingAccount;
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
public class BillingAccountMapperImpl implements BillingAccountMapper {

    @Override
    public CreateBillingAccountResponse BillingAccountFromCreateResponse(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        CreateBillingAccountResponse createBillingAccountResponse = new CreateBillingAccountResponse();

        createBillingAccountResponse.setCustomerId( billingAccountCustomerId( billingAccount ) );
        createBillingAccountResponse.setId( billingAccount.getId() );
        createBillingAccountResponse.setAddress( billingAccount.getAddress() );
        createBillingAccountResponse.setDescription( billingAccount.getDescription() );
        createBillingAccountResponse.setAccountName( billingAccount.getAccountName() );
        createBillingAccountResponse.setAccountNumber( billingAccount.getAccountNumber() );
        createBillingAccountResponse.setAccountStatus( billingAccount.getAccountStatus() );
        createBillingAccountResponse.setAccountType( billingAccount.getAccountType() );

        return createBillingAccountResponse;
    }

    @Override
    public UpdateBillingAccountResponse BillingAccountFromUpdateResponse(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        UpdateBillingAccountResponse updateBillingAccountResponse = new UpdateBillingAccountResponse();

        updateBillingAccountResponse.setCustomerId( billingAccountCustomerId( billingAccount ) );
        updateBillingAccountResponse.setId( billingAccount.getId() );

        return updateBillingAccountResponse;
    }

    @Override
    public DeleteBillingAccountResponse BillingAccountFromDeleteResponse(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        DeleteBillingAccountResponse deleteBillingAccountResponse = new DeleteBillingAccountResponse();

        deleteBillingAccountResponse.setCustomerId( billingAccountCustomerId( billingAccount ) );
        deleteBillingAccountResponse.setId( billingAccount.getId() );

        return deleteBillingAccountResponse;
    }

    @Override
    public List<GetAllBillingAccountResponse> getAll(List<BillingAccount> billingAccounts) {
        if ( billingAccounts == null ) {
            return null;
        }

        List<GetAllBillingAccountResponse> list = new ArrayList<GetAllBillingAccountResponse>( billingAccounts.size() );
        for ( BillingAccount billingAccount : billingAccounts ) {
            list.add( billingAccountToGetAllBillingAccountResponse( billingAccount ) );
        }

        return list;
    }

    @Override
    public GetByIdBillingAccountResponse getBillingAccountById(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        GetByIdBillingAccountResponse getByIdBillingAccountResponse = new GetByIdBillingAccountResponse();

        getByIdBillingAccountResponse.setCustomerId( billingAccountCustomerId( billingAccount ) );
        getByIdBillingAccountResponse.setId( billingAccount.getId() );
        getByIdBillingAccountResponse.setAccountNumber( billingAccount.getAccountNumber() );
        getByIdBillingAccountResponse.setAccountStatus( billingAccount.getAccountStatus() );
        getByIdBillingAccountResponse.setAction( billingAccount.getAction() );
        getByIdBillingAccountResponse.setAccountName( billingAccount.getAccountName() );

        return getByIdBillingAccountResponse;
    }

    @Override
    public BillingAccount billingAccountFromCreateRequest(CreateBillingAccountRequest request) {
        if ( request == null ) {
            return null;
        }

        BillingAccount billingAccount = new BillingAccount();

        billingAccount.setCustomer( createBillingAccountRequestToCustomer( request ) );
        billingAccount.setAccountNumber( request.getAccountNumber() );
        billingAccount.setAddress( request.getAddress() );
        billingAccount.setDescription( request.getDescription() );
        billingAccount.setAccountStatus( request.getAccountStatus() );
        billingAccount.setAccountName( request.getAccountName() );
        billingAccount.setAccountType( request.getAccountType() );

        return billingAccount;
    }

    @Override
    public BillingAccount billingAccountFromUpdateRequest(UpdateBillingAccountRequest request) {
        if ( request == null ) {
            return null;
        }

        BillingAccount billingAccount = new BillingAccount();

        billingAccount.setCustomer( updateBillingAccountRequestToCustomer( request ) );

        return billingAccount;
    }

    private UUID billingAccountCustomerId(BillingAccount billingAccount) {
        Customer customer = billingAccount.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getId();
    }

    protected GetAllBillingAccountResponse billingAccountToGetAllBillingAccountResponse(BillingAccount billingAccount) {
        if ( billingAccount == null ) {
            return null;
        }

        GetAllBillingAccountResponse getAllBillingAccountResponse = new GetAllBillingAccountResponse();

        getAllBillingAccountResponse.setId( billingAccount.getId() );
        getAllBillingAccountResponse.setAccountNumber( billingAccount.getAccountNumber() );
        getAllBillingAccountResponse.setAccountStatus( billingAccount.getAccountStatus() );
        getAllBillingAccountResponse.setAction( billingAccount.getAction() );

        return getAllBillingAccountResponse;
    }

    protected Customer createBillingAccountRequestToCustomer(CreateBillingAccountRequest createBillingAccountRequest) {
        if ( createBillingAccountRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( createBillingAccountRequest.getCustomerId() );

        return customer;
    }

    protected Customer updateBillingAccountRequestToCustomer(UpdateBillingAccountRequest updateBillingAccountRequest) {
        if ( updateBillingAccountRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( updateBillingAccountRequest.getCustomerId() );

        return customer;
    }
}
