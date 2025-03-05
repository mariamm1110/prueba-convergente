package com.convergente.pruebaconvergente.controllers;

import com.convergente.pruebaconvergente.dtos.UserDTO;
import com.convergente.pruebaconvergente.models.User;
import com.convergente.pruebaconvergente.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public List<User> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("/newuser")
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDto) {
        User createdUser = this.userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

}
