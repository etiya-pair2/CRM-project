package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.billingAccount.*;
import com.etiya.customerservice.dto.contactMedium.DeleteContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.GetAllContactMediumResponse;
import com.etiya.customerservice.dto.contactMedium.UpdateContactMediumRequest;
import com.etiya.customerservice.dto.contactMedium.UpdateContactMediumResponse;
import com.etiya.customerservice.service.abstracts.BillingAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/customer/billingAccounts")
@RequiredArgsConstructor
public class BillingAccountController {
    private final BillingAccountService billingAccountService;

    @GetMapping("/getAll")
    public List<GetAllBillingAccountResponse> getAll(){
        return billingAccountService.getAll();
    }
    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdBillingAccountResponse> getById(@PathVariable("getById")UUID id){
        if(billingAccountService.getById(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billingAccountService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateBillingAccountResponse> add(@RequestBody @Valid CreateBillingAccountRequest request){
        CreateBillingAccountResponse saved= billingAccountService.create(request);
        if(saved!=null){
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @DeleteMapping("/delete")
    public DeleteBillingAccountResponse delete(@RequestParam UUID id){

        return billingAccountService.delete(id);
    }

    @PutMapping("/update")
    public UpdateBillingAccountResponse update(@RequestBody @Valid UpdateBillingAccountRequest request){
        return billingAccountService.update(request);
    }
}
