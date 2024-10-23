package com.etiya.productservice.controller;

import com.etiya.productservice.dto.attribute.*;
import com.etiya.productservice.dto.product.*;
import com.etiya.productservice.entity.Product;
import com.etiya.productservice.service.abstracts.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllProductResponse>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    //PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdProductResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(productService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest request){
        return ResponseEntity.ok(productService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateProductResponse> update(@RequestBody UpdateProductRequest request){
        return new ResponseEntity<>(productService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteProductResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(productService.delete(id),HttpStatus.OK);
    }

    @PostMapping("search")
    public List<Product> getByIds(@RequestBody List<UUID> ids)
    {
        return productService.search(ids);
    }
}