package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.corporateCustomer.*;
import com.etiya.customerservice.dto.individualCustomer.*;
import com.etiya.customerservice.service.abstracts.CorporateCustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer/corporateCustomers")
@RequiredArgsConstructor
public class CorporateCustomerController {
    private final CorporateCustomerService corporateCustomerService;

    @GetMapping("/getAll")
    public List<GetAllCorporateCustomerResponse> getAll(){
        return corporateCustomerService.getAll();
    }

    @GetMapping("/getById")
    public ResponseEntity<GetByIdCorporateCustomerResponse> getById(@PathVariable("getById")UUID id){
        if(corporateCustomerService.getById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(corporateCustomerService.getById(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<CreateCorporateCustomerResponse> add(@RequestBody @Valid CreateCorporateCustomerRequest request){
        CreateCorporateCustomerResponse saved= corporateCustomerService.create(request);
        if(saved != null){
            return  new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete")
    public DeleteCorporateCustomerResponse delete(@RequestParam UUID id){
        return corporateCustomerService.delete(id);
    }

    @PutMapping("/update")
    public UpdateCorporateCustomerResponse update(@RequestBody @Valid UpdateCorporateCustomerRequest request){
        return corporateCustomerService.update(request);
    }

}
