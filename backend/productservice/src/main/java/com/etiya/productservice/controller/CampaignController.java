package com.etiya.productservice.controller;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.service.abstracts.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/camapigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllCampaignResponse>> getAll(){
        return new ResponseEntity<>(campaignService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdCampaignResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(campaignService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateCampaignResponse> create(@RequestBody CreateCampaignRequest request){
        return ResponseEntity.ok(campaignService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateCampaignResponse> update(@RequestBody UpdateCampaignRequest request){
        return new ResponseEntity<>(campaignService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCampaignResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(campaignService.delete(id),HttpStatus.OK);
    }
}
