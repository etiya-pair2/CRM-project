package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.district.CreateDistrictRequest;
import com.etiya.customerservice.dto.district.CreateDistrictResponse;
import com.etiya.customerservice.dto.district.DeleteDistrictResponse;
import com.etiya.customerservice.dto.district.GetAllDistrictResponse;
import com.etiya.customerservice.dto.district.GetByIdDistrictResponse;
import com.etiya.customerservice.dto.district.UpdateDistrictRequest;
import com.etiya.customerservice.dto.district.UpdateDistrictResponse;
import com.etiya.customerservice.entity.City;
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
public class DistrictMapperImpl implements DistrictMapper {

    @Override
    public CreateDistrictResponse districtFromCreateResponse(District district) {
        if ( district == null ) {
            return null;
        }

        CreateDistrictResponse createDistrictResponse = new CreateDistrictResponse();

        createDistrictResponse.setCityId( districtCityId( district ) );
        createDistrictResponse.setId( district.getId() );
        createDistrictResponse.setName( district.getName() );

        return createDistrictResponse;
    }

    @Override
    public UpdateDistrictResponse districtFromUpdateResponse(District district) {
        if ( district == null ) {
            return null;
        }

        UpdateDistrictResponse updateDistrictResponse = new UpdateDistrictResponse();

        updateDistrictResponse.setCityId( districtCityId( district ) );
        updateDistrictResponse.setId( district.getId() );
        updateDistrictResponse.setName( district.getName() );

        return updateDistrictResponse;
    }

    @Override
    public DeleteDistrictResponse districtFromDeleteResponse(District district) {
        if ( district == null ) {
            return null;
        }

        DeleteDistrictResponse deleteDistrictResponse = new DeleteDistrictResponse();

        deleteDistrictResponse.setCityId( districtCityId( district ) );
        deleteDistrictResponse.setId( district.getId() );

        return deleteDistrictResponse;
    }

    @Override
    public List<GetAllDistrictResponse> districtFromGetAllResponse(List<District> district) {
        if ( district == null ) {
            return null;
        }

        List<GetAllDistrictResponse> list = new ArrayList<GetAllDistrictResponse>( district.size() );
        for ( District district1 : district ) {
            list.add( districtToGetAllDistrictResponse( district1 ) );
        }

        return list;
    }

    @Override
    public GetByIdDistrictResponse getDistrictById(District district) {
        if ( district == null ) {
            return null;
        }

        GetByIdDistrictResponse getByIdDistrictResponse = new GetByIdDistrictResponse();

        getByIdDistrictResponse.setCityId( districtCityId( district ) );
        getByIdDistrictResponse.setName( district.getName() );

        return getByIdDistrictResponse;
    }

    @Override
    public District districtFromCreateRequest(CreateDistrictRequest request) {
        if ( request == null ) {
            return null;
        }

        District district = new District();

        district.setCity( createDistrictRequestToCity( request ) );
        district.setName( request.getName() );

        return district;
    }

    @Override
    public District districtFromUpdateRequest(UpdateDistrictRequest request) {
        if ( request == null ) {
            return null;
        }

        District district = new District();

        district.setCity( updateDistrictRequestToCity( request ) );
        district.setId( request.getId() );
        district.setName( request.getName() );

        return district;
    }

    private UUID districtCityId(District district) {
        City city = district.getCity();
        if ( city == null ) {
            return null;
        }
        return city.getId();
    }

    protected GetAllDistrictResponse districtToGetAllDistrictResponse(District district) {
        if ( district == null ) {
            return null;
        }

        GetAllDistrictResponse getAllDistrictResponse = new GetAllDistrictResponse();

        getAllDistrictResponse.setId( district.getId() );
        getAllDistrictResponse.setName( district.getName() );

        return getAllDistrictResponse;
    }

    protected City createDistrictRequestToCity(CreateDistrictRequest createDistrictRequest) {
        if ( createDistrictRequest == null ) {
            return null;
        }

        City city = new City();

        city.setId( createDistrictRequest.getCityId() );

        return city;
    }

    protected City updateDistrictRequestToCity(UpdateDistrictRequest updateDistrictRequest) {
        if ( updateDistrictRequest == null ) {
            return null;
        }

        City city = new City();

        city.setId( updateDistrictRequest.getCityId() );

        return city;
    }
}
