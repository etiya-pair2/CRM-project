package com.etiya.productservice.controller;

import com.etiya.productservice.dto.campaign.*;
import com.etiya.productservice.dto.offer.*;
import com.etiya.productservice.entity.Offer;
import com.etiya.productservice.service.abstracts.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/offer")
@RequiredArgsConstructor
public class OfferController {

    private final OfferService offerService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllOfferResponse>> getAll(){
        return new ResponseEntity<>(offerService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdOfferResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(offerService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateOfferResponse> create(@RequestBody CreateOfferRequest request){
        return ResponseEntity.ok(offerService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateOfferResponse> update(@RequestBody UpdateOfferRequest request){
        return new ResponseEntity<>(offerService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteOfferResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(offerService.delete(id),HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public Offer findById(@PathVariable UUID id) {
        return offerService.findById(id);
    }
}
