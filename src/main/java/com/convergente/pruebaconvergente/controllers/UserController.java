package com.convergente.pruebaconvergente.controllers;

import com.convergente.pruebaconvergente.dtos.UserDTO;
import com.convergente.pruebaconvergente.models.User;
import com.convergente.pruebaconvergente.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/newuser")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        this.userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
