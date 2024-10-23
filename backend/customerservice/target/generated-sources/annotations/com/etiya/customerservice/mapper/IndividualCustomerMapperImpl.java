package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerRequest;
import com.etiya.customerservice.dto.individualCustomer.CreateIndividualCustomerResponse;
import com.etiya.customerservice.dto.individualCustomer.DeleteIndividualCustomerResponse;
import com.etiya.customerservice.dto.individualCustomer.GetAllIndividualCustomerResponse;
import com.etiya.customerservice.dto.individualCustomer.GetByIdIndividualCustomerResponse;
import com.etiya.customerservice.dto.individualCustomer.UpdateIndividualCustomerRequest;
import com.etiya.customerservice.dto.individualCustomer.UpdateIndividualCustomerResponse;
import com.etiya.customerservice.entity.IndividualCustomer;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class IndividualCustomerMapperImpl implements IndividualCustomerMapper {

    @Override
    public CreateIndividualCustomerResponse individualCustomerFromCreateResponse(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        CreateIndividualCustomerResponse createIndividualCustomerResponse = new CreateIndividualCustomerResponse();

        createIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        createIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        createIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        createIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        createIndividualCustomerResponse.setBirthday( individualCustomer.getBirthday() );
        createIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        createIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        createIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );

        return createIndividualCustomerResponse;
    }

    @Override
    public UpdateIndividualCustomerResponse individualCustomerFromUpdateResponse(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        UpdateIndividualCustomerResponse updateIndividualCustomerResponse = new UpdateIndividualCustomerResponse();

        updateIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        updateIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        updateIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        updateIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        updateIndividualCustomerResponse.setBirthday( individualCustomer.getBirthday() );
        updateIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        updateIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        updateIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );

        return updateIndividualCustomerResponse;
    }

    @Override
    public DeleteIndividualCustomerResponse individualCustomerFromDeleteResponse(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        DeleteIndividualCustomerResponse deleteIndividualCustomerResponse = new DeleteIndividualCustomerResponse();

        return deleteIndividualCustomerResponse;
    }

    @Override
    public List<GetAllIndividualCustomerResponse> individualCustomerFromGetAllResponse(List<IndividualCustomer> individualCustomers) {
        if ( individualCustomers == null ) {
            return null;
        }

        List<GetAllIndividualCustomerResponse> list = new ArrayList<GetAllIndividualCustomerResponse>( individualCustomers.size() );
        for ( IndividualCustomer individualCustomer : individualCustomers ) {
            list.add( individualCustomerToGetAllIndividualCustomerResponse( individualCustomer ) );
        }

        return list;
    }

    @Override
    public GetByIdIndividualCustomerResponse getIndividualCustomerById(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        GetByIdIndividualCustomerResponse getByIdIndividualCustomerResponse = new GetByIdIndividualCustomerResponse();

        getByIdIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        getByIdIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        getByIdIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        getByIdIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        getByIdIndividualCustomerResponse.setBirthday( individualCustomer.getBirthday() );
        getByIdIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        getByIdIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        getByIdIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );

        return getByIdIndividualCustomerResponse;
    }

    @Override
    public IndividualCustomer individualCustomerFromCreateRequest(CreateIndividualCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setFirstName( request.getFirstName() );
        individualCustomer.setMiddleName( request.getMiddleName() );
        individualCustomer.setLastName( request.getLastName() );
        individualCustomer.setGender( request.getGender() );
        individualCustomer.setBirthday( request.getBirthday() );
        individualCustomer.setMotherName( request.getMotherName() );
        individualCustomer.setFatherName( request.getFatherName() );
        individualCustomer.setNationalityId( request.getNationalityId() );

        return individualCustomer;
    }

    @Override
    public IndividualCustomer individualCustomerFromUpdateRequest(UpdateIndividualCustomerRequest request) {
        if ( request == null ) {
            return null;
        }

        IndividualCustomer individualCustomer = new IndividualCustomer();

        individualCustomer.setFirstName( request.getFirstName() );
        individualCustomer.setMiddleName( request.getMiddleName() );
        individualCustomer.setLastName( request.getLastName() );
        individualCustomer.setGender( request.getGender() );
        individualCustomer.setBirthday( request.getBirthday() );
        individualCustomer.setMotherName( request.getMotherName() );
        individualCustomer.setFatherName( request.getFatherName() );
        individualCustomer.setNationalityId( request.getNationalityId() );

        return individualCustomer;
    }

    protected GetAllIndividualCustomerResponse individualCustomerToGetAllIndividualCustomerResponse(IndividualCustomer individualCustomer) {
        if ( individualCustomer == null ) {
            return null;
        }

        GetAllIndividualCustomerResponse getAllIndividualCustomerResponse = new GetAllIndividualCustomerResponse();

        getAllIndividualCustomerResponse.setFirstName( individualCustomer.getFirstName() );
        getAllIndividualCustomerResponse.setMiddleName( individualCustomer.getMiddleName() );
        getAllIndividualCustomerResponse.setLastName( individualCustomer.getLastName() );
        getAllIndividualCustomerResponse.setGender( individualCustomer.getGender() );
        getAllIndividualCustomerResponse.setBirthday( individualCustomer.getBirthday() );
        getAllIndividualCustomerResponse.setMotherName( individualCustomer.getMotherName() );
        getAllIndividualCustomerResponse.setFatherName( individualCustomer.getFatherName() );
        getAllIndividualCustomerResponse.setNationalityId( individualCustomer.getNationalityId() );

        return getAllIndividualCustomerResponse;
    }
}
