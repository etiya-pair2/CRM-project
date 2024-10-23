package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.city.*;
import com.etiya.customerservice.dto.customer.UpdateCustomerRequest;
import com.etiya.customerservice.service.abstracts.CityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/customer/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("/getAll")
    public List<GetAllCityResponse> getAll(){
        return cityService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdCityResponse> getById(@PathVariable("getById")UUID id){
        if(cityService.getById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateCityResponse> add(@RequestBody @Valid CreateCityRequest request){
        CreateCityResponse saved= cityService.create(request);
        if(saved!=null){
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public DeleteCityResponse delete(@RequestParam UUID id){
        return cityService.delete(id);
    }

    @PutMapping("/update")
    public UpdateCityResponse update(@RequestBody @Valid UpdateCityRequest request){
        return cityService.update(request);
    }
}
