package com.etiya.customerservice.service.concretes;

import com.etiya.customerservice.dto.district.*;
import com.etiya.customerservice.entity.District;
import com.etiya.customerservice.mapper.DistrictMapper;
import com.etiya.customerservice.repository.DistrictRepository;
import com.etiya.customerservice.service.abstracts.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Override
    public CreateDistrictResponse create(CreateDistrictRequest request) {
        District district= DistrictMapper.INSTANCE.districtFromCreateRequest(request);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.districtFromCreateResponse(district);
    }

    @Override
    public UpdateDistrictResponse update(UpdateDistrictRequest request) {
        District district= DistrictMapper.INSTANCE.districtFromUpdateRequest(request);
        districtRepository.save(district);
        return DistrictMapper.INSTANCE.districtFromUpdateResponse(district);
    }

    @Override
    public DeleteDistrictResponse delete(UUID districtId) {
        District district= (District) districtRepository.findById(districtId).orElseThrow(() ->
                        new RuntimeException("District not found with ID: " + districtId));
        districtRepository.delete(district);
        return DistrictMapper.INSTANCE.districtFromDeleteResponse(district);
    }

    @Override
    public List<GetAllDistrictResponse> getAll() {
        List<District> districts= districtRepository.findAll();
        List<GetAllDistrictResponse> getAllDistrictResponseList= new ArrayList<>();
        for(District district:districts){
            getAllDistrictResponseList.add(DistrictMapper.INSTANCE.districtFromGetAllResponse(district));
        }
        return getAllDistrictResponseList;
    }

    @Override
    public GetByIdDistrictResponse getById(UUID districtId) {
        District district= districtRepository.findById(districtId).orElseThrow(() ->
                new RuntimeException("District not found with ID: " + districtId));
        return DistrictMapper.INSTANCE.getDistrictById(district);
    }

    @Override
    public List<GetByCityIdDistrictResponse> getDistrictsFromCity(UUID id) {
        List<District> districts= districtRepository.findByCityId(id);
        List<GetByCityIdDistrictResponse> getAll= new ArrayList<>();
        for(District district:districts){
            getAll.add(DistrictMapper.INSTANCE.getDistrictByCityId(district));
        }
        return getAll;
    }
}
