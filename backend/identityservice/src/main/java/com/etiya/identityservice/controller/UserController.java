package com.etiya.identityservice.controller;

import com.etiya.identityservice.dto.User.*;
import com.etiya.identityservice.service.abstracts.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/identity/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/getAll")
    public List<GetAllUserResponse> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetByIdUserResponse> getById(@PathVariable("id") UUID id) {
        GetByIdUserResponse userResponse = userService.getById(id);
        if (userResponse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> create(@RequestBody @Valid CreateUserRequest request) {
        CreateUserResponse savedUser = userService.create(request);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DeleteUserResponse> delete(@RequestParam UUID id) {
        DeleteUserResponse deleteResponse = userService.delete(id);
        return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateUserResponse> update(@RequestBody @Valid UpdateUserRequest request) {
        UpdateUserResponse updatedUser = userService.update(request);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
