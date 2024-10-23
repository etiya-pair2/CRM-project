package com.etiya.productservice.controller;

import com.etiya.productservice.dto.campaignProduct.*;
import com.etiya.productservice.dto.productAttribute.*;
import com.etiya.productservice.service.abstracts.CampaignProductService;
import com.etiya.productservice.service.abstracts.ProductAttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/product-attributes")
@RequiredArgsConstructor
public class ProductAttributeController {

    private final ProductAttributeService productAttributeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllProductAttributeResponse>> getAll(){
        return new ResponseEntity<>(productAttributeService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdProductAttributeResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(productAttributeService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateProductAttributeResponse> create(@RequestBody CreateProductAttributeRequest request){
        return ResponseEntity.ok(productAttributeService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateProductAttributeResponse> update(@RequestBody UpdateProductAttributeRequest request){
        return new ResponseEntity<>(productAttributeService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteProductAttributeResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(productAttributeService.delete(id),HttpStatus.OK);
    }
}
