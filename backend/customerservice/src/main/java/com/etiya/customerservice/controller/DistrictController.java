package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.district.*;
import com.etiya.customerservice.service.abstracts.DistrictService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/districts")
@RequiredArgsConstructor
public class DistrictController {
    private final DistrictService districtService;

    @GetMapping("/getAll")
    public List<GetAllDistrictResponse> getAll(){

        return districtService.getAll();
    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdDistrictResponse> getById(@PathVariable UUID id) {
        if (districtService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(districtService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateDistrictResponse> add(@RequestBody @Valid CreateDistrictRequest request){
        CreateDistrictResponse saved= districtService.create(request);
        if(saved != null){
            return  new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public DeleteDistrictResponse delete(@RequestParam UUID id){
        return districtService.delete(id);
    }

    @PutMapping("/update")
    public UpdateDistrictResponse update(@RequestBody @Valid UpdateDistrictRequest request){
        return districtService.update(request);
    }
    @GetMapping("/getCityId/{id}")
    public ResponseEntity<List<GetByCityIdDistrictResponse>> getDistrictsFromCity(@PathVariable UUID id) {
        List<GetByCityIdDistrictResponse> districts = districtService.getDistrictsFromCity(id);
        return  new ResponseEntity<>(districts,HttpStatus.OK);
    }
}
