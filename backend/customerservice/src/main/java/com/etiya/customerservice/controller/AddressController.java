package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.address.*;
import com.etiya.customerservice.service.abstracts.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/customer/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/getAll")
    public List<GetAllAddressResponse> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdAddressResponse> getById(@PathVariable("getById") UUID id) {
        if (addressService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addressService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CreateAddressResponse> add(@RequestBody @Valid CreateAddressRequest request){
        CreateAddressResponse saved= addressService.create(request);
        if(saved != null){
            return  new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete")
    public DeleteAddressResponse delete(@RequestParam UUID id){

        return addressService.delete(id);
    }

    @PutMapping("/update")
    public UpdateAddressResponse update(@RequestBody @Valid UpdateAddressRequest request){
        return addressService.update(request);
    }
}
