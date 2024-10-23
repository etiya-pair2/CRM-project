package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.city.CreateCityRequest;
import com.etiya.customerservice.dto.city.CreateCityResponse;
import com.etiya.customerservice.dto.city.DeleteCityResponse;
import com.etiya.customerservice.dto.city.GetAllCityResponse;
import com.etiya.customerservice.dto.city.GetByIdCityResponse;
import com.etiya.customerservice.dto.city.UpdateCityRequest;
import com.etiya.customerservice.dto.city.UpdateCityResponse;
import com.etiya.customerservice.entity.City;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:15:19+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 23 (Oracle Corporation)"
)
public class CityMapperImpl implements CityMapper {

    @Override
    public CreateCityResponse cityFromCreateResponse(City city) {
        if ( city == null ) {
            return null;
        }

        CreateCityResponse createCityResponse = new CreateCityResponse();

        createCityResponse.setId( city.getId() );
        createCityResponse.setName( city.getName() );

        return createCityResponse;
    }

    @Override
    public UpdateCityResponse cityFromUpdateResponse(City city) {
        if ( city == null ) {
            return null;
        }

        UpdateCityResponse updateCityResponse = new UpdateCityResponse();

        updateCityResponse.setId( city.getId() );
        updateCityResponse.setName( city.getName() );

        return updateCityResponse;
    }

    @Override
    public DeleteCityResponse cityFromDeleteResponse(City city) {
        if ( city == null ) {
            return null;
        }

        DeleteCityResponse deleteCityResponse = new DeleteCityResponse();

        deleteCityResponse.setId( city.getId() );
        deleteCityResponse.setName( city.getName() );

        return deleteCityResponse;
    }

    @Override
    public List<GetAllCityResponse> cityFromGetAllResponse(List<City> cities) {
        if ( cities == null ) {
            return null;
        }

        List<GetAllCityResponse> list = new ArrayList<GetAllCityResponse>( cities.size() );
        for ( City city : cities ) {
            list.add( cityToGetAllCityResponse( city ) );
        }

        return list;
    }

    @Override
    public GetByIdCityResponse getCityById(City city) {
        if ( city == null ) {
            return null;
        }

        GetByIdCityResponse getByIdCityResponse = new GetByIdCityResponse();

        getByIdCityResponse.setName( city.getName() );

        return getByIdCityResponse;
    }

    @Override
    public City cityFromCreateRequest(CreateCityRequest request) {
        if ( request == null ) {
            return null;
        }

        City city = new City();

        city.setName( request.getName() );

        return city;
    }

    @Override
    public City cityFromUpdateRequest(UpdateCityRequest request) {
        if ( request == null ) {
            return null;
        }

        City city = new City();

        city.setId( request.getId() );
        city.setName( request.getName() );

        return city;
    }

    protected GetAllCityResponse cityToGetAllCityResponse(City city) {
        if ( city == null ) {
            return null;
        }

        GetAllCityResponse getAllCityResponse = new GetAllCityResponse();

        getAllCityResponse.setId( city.getId() );
        getAllCityResponse.setName( city.getName() );

        return getAllCityResponse;
    }
}
