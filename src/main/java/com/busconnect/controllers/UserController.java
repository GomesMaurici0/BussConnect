package com.busconnect.controllers;

import com.busconnect.entities.UserClientEntity;
import com.busconnect.models.UserClientModel;
import com.busconnect.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserClientEntity> postUser(@RequestBody @Valid UserClientModel userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(userDTO));
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}