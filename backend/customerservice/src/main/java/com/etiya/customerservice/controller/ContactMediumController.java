package com.etiya.customerservice.controller;

import com.etiya.customerservice.dto.contactMedium.*;
import com.etiya.customerservice.service.abstracts.ContactMediumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/api/v1/customer/contactMediums")
@RequiredArgsConstructor
public class ContactMediumController {
    private final ContactMediumService contactMediumService;

    @GetMapping("/getAll")
    public List<GetAllContactMediumResponse> getAll(){
        return contactMediumService.getAll();
    }
    @GetMapping("/{getById}")
    public ResponseEntity<GetByIdContactMediumResponse> getById(@PathVariable("getById") UUID id) {
        if (contactMediumService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(contactMediumService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateContactMediumResponse> add(@RequestBody CreateContactMediumRequest request){
        CreateContactMediumResponse saved = contactMediumService.create(request);
//        if(saved != null){
//            return  new ResponseEntity<>(saved,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           return  new ResponseEntity<>(saved,HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public DeleteContactMediumResponse delete(@RequestParam UUID id){

        return contactMediumService.delete(id);
    }

    @PutMapping("/update")
    public UpdateContactMediumResponse update(@RequestBody UpdateContactMediumRequest request){
        return contactMediumService.update(request);
    }

}
