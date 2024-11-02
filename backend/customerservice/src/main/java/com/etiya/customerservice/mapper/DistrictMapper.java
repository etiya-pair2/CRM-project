package com.etiya.customerservice.mapper;

import com.etiya.customerservice.dto.district.*;
import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.entity.IndividualCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DistrictMapper {
    DistrictMapper INSTANCE = Mappers.getMapper(DistrictMapper.class);
    @Mapping(source = "city.id", target = "cityId")
    CreateDistrictResponse districtFromCreateResponse(District district);

    @Mapping(source = "city.id",target="cityId" )
    UpdateDistrictResponse districtFromUpdateResponse(District district);
    @Mapping(source = "city.id",target="cityId" )
    DeleteDistrictResponse districtFromDeleteResponse(District district);
    @Mapping(source = "city.id",target="cityId" )
    GetAllDistrictResponse districtFromGetAllResponse(District district);
    @Mapping(source = "city.id",target="cityId" )
    GetByIdDistrictResponse getDistrictById(District district);

    GetByCityIdDistrictResponse getDistrictByCityId(District district);
    @Mapping(source = "cityId",target="city.id" )
    District districtFromCreateRequest(CreateDistrictRequest request);
    @Mapping(source = "cityId",target="city.id" )
    District districtFromUpdateRequest(UpdateDistrictRequest request);
}
