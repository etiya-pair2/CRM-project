package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.address.CreateAddressRequest;
import com.etiya.customerservice.dto.address.CreateAddressResponse;
import com.etiya.customerservice.dto.address.DeleteAddressResponse;
import com.etiya.customerservice.dto.address.GetAllAddressResponse;
import com.etiya.customerservice.dto.address.GetByIdAddressResponse;
import com.etiya.customerservice.dto.address.UpdateAddressRequest;
import com.etiya.customerservice.dto.address.UpdateAddressResponse;
import com.etiya.customerservice.entity.Address;
import com.etiya.customerservice.entity.Customer;
import com.etiya.customerservice.entity.District;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class AddressMapperImpl implements AddressMapper {

    @Override
    public CreateAddressResponse addressFromCreateResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        CreateAddressResponse createAddressResponse = new CreateAddressResponse();

        createAddressResponse.setCustomerId( addressCustomerId( address ) );
        createAddressResponse.setDistrictId( addressDistrictId( address ) );
        createAddressResponse.setId( address.getId() );
        createAddressResponse.setPostalCode( address.getPostalCode() );
        createAddressResponse.setDescription( address.getDescription() );

        return createAddressResponse;
    }

    @Override
    public UpdateAddressResponse addressFromUpdateResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        UpdateAddressResponse updateAddressResponse = new UpdateAddressResponse();

        updateAddressResponse.setCustomerId( addressCustomerId( address ) );
        updateAddressResponse.setDistrictId( addressDistrictId( address ) );
        updateAddressResponse.setId( address.getId() );
        updateAddressResponse.setPostalCode( address.getPostalCode() );
        updateAddressResponse.setDescription( address.getDescription() );
        updateAddressResponse.setFlatNumber( address.getFlatNumber() );

        return updateAddressResponse;
    }

    @Override
    public DeleteAddressResponse addressFromDeleteResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        DeleteAddressResponse deleteAddressResponse = new DeleteAddressResponse();

        deleteAddressResponse.setCustomerId( addressCustomerId( address ) );
        deleteAddressResponse.setDistrictId( addressDistrictId( address ) );
        deleteAddressResponse.setId( address.getId() );

        return deleteAddressResponse;
    }

    @Override
    public List<GetAllAddressResponse> addressFromGetAllResponse(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<GetAllAddressResponse> list = new ArrayList<GetAllAddressResponse>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( addressToGetAllAddressResponse( address ) );
        }

        return list;
    }

    @Override
    public GetByIdAddressResponse getAddressById(Address address) {
        if ( address == null ) {
            return null;
        }

        GetByIdAddressResponse getByIdAddressResponse = new GetByIdAddressResponse();

        getByIdAddressResponse.setCustomerId( addressCustomerId( address ) );
        getByIdAddressResponse.setDistrictId( addressDistrictId( address ) );
        getByIdAddressResponse.setId( address.getId() );
        getByIdAddressResponse.setPostalCode( address.getPostalCode() );
        getByIdAddressResponse.setDescription( address.getDescription() );
        getByIdAddressResponse.setFlatNumber( address.getFlatNumber() );

        return getByIdAddressResponse;
    }

    @Override
    public Address addressFromCreateRequest(CreateAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        Address address = new Address();

        address.setCustomer( createAddressRequestToCustomer( request ) );
        address.setDistrict( createAddressRequestToDistrict( request ) );
        address.setPostalCode( request.getPostalCode() );
        address.setDescription( request.getDescription() );
        address.setFlatNumber( request.getFlatNumber() );

        return address;
    }

    @Override
    public Address addressFromUpdateRequest(UpdateAddressRequest request) {
        if ( request == null ) {
            return null;
        }

        Address address = new Address();

        address.setCustomer( updateAddressRequestToCustomer( request ) );
        address.setDistrict( updateAddressRequestToDistrict( request ) );
        address.setId( request.getId() );
        address.setPostalCode( request.getPostalCode() );
        address.setDescription( request.getDescription() );
        address.setFlatNumber( request.getFlatNumber() );

        return address;
    }

    private UUID addressCustomerId(Address address) {
        Customer customer = address.getCustomer();
        if ( customer == null ) {
            return null;
        }
        return customer.getId();
    }

    private UUID addressDistrictId(Address address) {
        District district = address.getDistrict();
        if ( district == null ) {
            return null;
        }
        return district.getId();
    }

    protected GetAllAddressResponse addressToGetAllAddressResponse(Address address) {
        if ( address == null ) {
            return null;
        }

        GetAllAddressResponse getAllAddressResponse = new GetAllAddressResponse();

        getAllAddressResponse.setId( address.getId() );
        getAllAddressResponse.setPostalCode( address.getPostalCode() );
        getAllAddressResponse.setDescription( address.getDescription() );
        getAllAddressResponse.setFlatNumber( address.getFlatNumber() );

        return getAllAddressResponse;
    }

    protected Customer createAddressRequestToCustomer(CreateAddressRequest createAddressRequest) {
        if ( createAddressRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( createAddressRequest.getCustomerId() );

        return customer;
    }

    protected District createAddressRequestToDistrict(CreateAddressRequest createAddressRequest) {
        if ( createAddressRequest == null ) {
            return null;
        }

        District district = new District();

        district.setId( createAddressRequest.getDistrictId() );

        return district;
    }

    protected Customer updateAddressRequestToCustomer(UpdateAddressRequest updateAddressRequest) {
        if ( updateAddressRequest == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( updateAddressRequest.getCustomerId() );

        return customer;
    }

    protected District updateAddressRequestToDistrict(UpdateAddressRequest updateAddressRequest) {
        if ( updateAddressRequest == null ) {
            return null;
        }

        District district = new District();

        district.setId( updateAddressRequest.getDistrictId() );

        return district;
    }
}
