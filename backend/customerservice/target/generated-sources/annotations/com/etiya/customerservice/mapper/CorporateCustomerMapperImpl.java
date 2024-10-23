package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.corporateCustomer.CreateCorporateCustomerRequest;
import com.etiya.customerservice.dto.corporateCustomer.CreateCorporateCustomerResponse;
import com.etiya.customerservice.dto.corporateCustomer.DeleteCorporateCustomerResponse;
import com.etiya.customerservice.dto.corporateCustomer.GetAllCorporateCustomerResponse;
import com.etiya.customerservice.dto.corporateCustomer.GetByIdCorporateCustomerResponse;
import com.etiya.customerservice.dto.corporateCustomer.UpdateCorporateCustomerRequest;
import com.etiya.customerservice.dto.corporateCustomer.UpdateCorporateCustomerResponse;
import com.etiya.customerservice.entity.CorporateCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class CorporateCustomerMapperImpl implements CorporateCustomerMapper {

    @Override
    public CreateCorporateCustomerResponse corporateCustomerFromCreateResponse(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        CreateCorporateCustomerResponse createCorporateCustomerResponse = new CreateCorporateCustomerResponse();

        createCorporateCustomerResponse.setCompanyName( corporateCustomer.getCompanyName() );
        createCorporateCustomerResponse.setTaxNo( corporateCustomer.getTaxNo() );

        return createCorporateCustomerResponse;
    }

    @Override
    public UpdateCorporateCustomerResponse corporateCustomerFromUpdateResponse(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        UpdateCorporateCustomerResponse updateCorporateCustomerResponse = new UpdateCorporateCustomerResponse();

        updateCorporateCustomerResponse.setCompanyName( corporateCustomer.getCompanyName() );
        updateCorporateCustomerResponse.setTaxNo( corporateCustomer.getTaxNo() );

        return updateCorporateCustomerResponse;
    }

    @Override
    public DeleteCorporateCustomerResponse corporateCustomerFromDeleteResponse(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        DeleteCorporateCustomerResponse deleteCorporateCustomerResponse = new DeleteCorporateCustomerResponse();

        return deleteCorporateCustomerResponse;
    }

    @Override
    public List<GetAllCorporateCustomerResponse> corporateCustomerFromGetAllResponse(List<CorporateCustomer> corporateCustomers) {
        if ( corporateCustomers == null ) {
            return null;
        }

        List<GetAllCorporateCustomerResponse> list = new ArrayList<GetAllCorporateCustomerResponse>( corporateCustomers.size() );
        for ( CorporateCustomer corporateCustomer : corporateCustomers ) {
            list.add( corporateCustomerToGetAllCorporateCustomerResponse( corporateCustomer ) );
        }

        return list;
    }

    @Override
    public GetByIdCorporateCustomerResponse getCustomerById(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        GetByIdCorporateCustomerResponse getByIdCorporateCustomerResponse = new GetByIdCorporateCustomerResponse();

        getByIdCorporateCustomerResponse.setCompanyName( corporateCustomer.getCompanyName() );
        getByIdCorporateCustomerResponse.setTaxNo( corporateCustomer.getTaxNo() );

        return getByIdCorporateCustomerResponse;
    }

    @Override
    public CorporateCustomer corporateCustomerFromCreateRequest(CreateCorporateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporateCustomer corporateCustomer = new CorporateCustomer();

        corporateCustomer.setCompanyName( request.getCompanyName() );
        corporateCustomer.setTaxNo( request.getTaxNo() );

        return corporateCustomer;
    }

    @Override
    public CorporateCustomer corporateCustomerFromUpdateRequest(UpdateCorporateCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        CorporateCustomer corporateCustomer = new CorporateCustomer();

        corporateCustomer.setCompanyName( request.getCompanyName() );
        corporateCustomer.setTaxNo( request.getTaxNo() );

        return corporateCustomer;
    }

    protected GetAllCorporateCustomerResponse corporateCustomerToGetAllCorporateCustomerResponse(CorporateCustomer corporateCustomer) {
        if ( corporateCustomer == null ) {
            return null;
        }

        GetAllCorporateCustomerResponse getAllCorporateCustomerResponse = new GetAllCorporateCustomerResponse();

        getAllCorporateCustomerResponse.setCompanyName( corporateCustomer.getCompanyName() );
        getAllCorporateCustomerResponse.setTaxNo( corporateCustomer.getTaxNo() );

        return getAllCorporateCustomerResponse;
    }
}
