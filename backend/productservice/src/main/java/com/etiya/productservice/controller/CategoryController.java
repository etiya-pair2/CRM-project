package com.etiya.productservice.controller;

import com.etiya.productservice.dto.category.*;
import com.etiya.productservice.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/getAll")
    public ResponseEntity<List<GetAllCategoryResponse>> getAll(){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    //TODO: PathVariable doc.
    @GetMapping("/getById/{id}")
    public ResponseEntity<GetByIdCategoryResponse> getById(@PathVariable UUID id){
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<CreateCategoryResponse> create(@RequestBody CreateCategoryRequest request){
        return ResponseEntity.ok(categoryService.create(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateCategoryResponse> update(@RequestBody UpdateCategoryRequest request){
        return new ResponseEntity<>(categoryService.update(request), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteCategoryResponse> delete(@RequestParam UUID id){
        return new ResponseEntity<>(categoryService.delete(id),HttpStatus.OK);
    }



}
