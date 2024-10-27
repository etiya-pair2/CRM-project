package com.etiya.productservice.controller;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.entity.Attribute;
import com.etiya.productservice.service.abstracts.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/attributes")
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;


    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllAttributeResponse>> getAll(){
        return new ResponseEntity<>(attributeService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdAttributeResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(attributeService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateAttributeResponse> create(@RequestBody CreateAttributeRequest request){
        CreateAttributeResponse attribute = attributeService.create(request);
        return ResponseEntity.ok(attribute);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateAttributeResponse> update(@RequestBody UpdateAttributeRequest request){
        return new ResponseEntity<>(attributeService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteAttributeResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(attributeService.delete(id),HttpStatus.OK);
    }


}
