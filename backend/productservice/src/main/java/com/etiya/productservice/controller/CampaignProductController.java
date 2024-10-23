package com.etiya.productservice.controller;

import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.dto.campaignProduct.*;
import com.etiya.productservice.service.abstracts.CampaignProductService;
import com.etiya.productservice.service.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/campaign-products")
@RequiredArgsConstructor
public class CampaignProductController {

    private final CampaignProductService campaignProductService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllCampaignProductResponse>> getAll(){
        return new ResponseEntity<>(campaignProductService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdCampaignProductResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(campaignProductService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateCampaignProductResponse> create(@RequestBody CreateCampaignProductRequest request){
        return ResponseEntity.ok(campaignProductService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateCampaignProductResponse> update(@RequestBody UpdateCampaignProductRequest request){
        return new ResponseEntity<>(campaignProductService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCampaignProductResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(campaignProductService.delete(id),HttpStatus.OK);
    }
}
