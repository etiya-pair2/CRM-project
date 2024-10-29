//package com.etiya.customerservice.controller;
//
//import com.etiya.customerservice.dto.customer.*;
//
//import com.etiya.customerservice.service.abstracts.CustomerService;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController()
//@RequestMapping("/api/v1/customer/customers")
//@RequiredArgsConstructor
//public class CustomerController {
//    private final CustomerService customerService;
//    @GetMapping("/getAll")
//    public List<GetAllCustomerResponse> getAll() {
//
//        return customerService.getAll();
//    }
//
//    @GetMapping("/{getById}")
//    public ResponseEntity<GetByIdCustomerResponse> getById(@PathVariable("getById") UUID id) {
//        if (customerService.getById(id) == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<CreateCustomerResponse> add(@RequestBody @Valid CreateCustomerRequest request){
//        CreateCustomerResponse saved= customerService.create(request);
//        if(saved != null){
//            return  new ResponseEntity<>(saved,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//
//    @DeleteMapping("/delete")
//    public DeleteCustomerResponse delete(@RequestParam UUID id){
//        return customerService.delete(id);
//    }
//
//    @PutMapping("/update")
//    public UpdateCustomerResponse update(@RequestBody @Valid UpdateCustomerRequest request){
//        return customerService.update(request);
//    }
//
//}
