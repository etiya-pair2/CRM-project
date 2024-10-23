package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.UserRole.*;
import com.etiya.identityservice.service.abstracts.UserRoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/identity/userRoles")
@RequiredArgsConstructor

public class UserRoleController {
    private final UserRoleService userRoleService;

    @GetMapping("/getAll")
    public List<GetAllUserRoleResponse> getAll() {
        return userRoleService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetByIdUserRoleResponse> getById(@PathVariable("id") UUID id) {
        GetByIdUserRoleResponse userRoleResponse = userRoleService.getById(id);
        if (userRoleResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRoleResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserRoleResponse> create(@RequestBody @Valid CreateUserRoleRequest request) {
        CreateUserRoleResponse savedUserRole = userRoleService.create(request);
        return new ResponseEntity<>(savedUserRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserRoleResponse> delete(@RequestParam UUID id) {
        DeleteUserRoleResponse deleteResponse = userRoleService.delete(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserRoleResponse> update(@RequestBody @Valid UpdateUserRoleRequest request) {
        UpdateUserRoleResponse updatedUserRole = userRoleService.update(request);
        return new ResponseEntity<>(updatedUserRole, HttpStatus.OK);
    }


}
