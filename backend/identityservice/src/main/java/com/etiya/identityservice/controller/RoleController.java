package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.Role.*;
import com.etiya.identityservice.service.abstracts.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/identity/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/getAll")
    public List<GetAllRoleResponse> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdRoleResponse> getById(@PathVariable("id") UUID id) {
        GetByIdRoleResponse roleResponse = roleService.getById(id);
        if (roleResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateRoleResponse> create(@RequestBody @Valid CreateRoleRequest request) {
        CreateRoleResponse savedRole = roleService.create(request);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteRoleResponse> delete(@RequestParam UUID id) {
        DeleteRoleResponse deleteResponse = roleService.delete(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateRoleResponse> update(@RequestBody @Valid UpdateRoleRequest request) {
        UpdateRoleResponse updatedRole = roleService.update(request);
        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
    }
}