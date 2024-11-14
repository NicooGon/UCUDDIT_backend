package com.example.ucuddit.controller;

import com.example.ucuddit.dto.UserDTO;
import com.example.ucuddit.interfaces.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user")
    public UserDTO checkOrCreateUser(@RequestBody UserDTO userDTO) {
        return userService.checkOrCreateUser(userDTO.getAuth0id(), userDTO.getName(), userDTO.getEmail(), userDTO.getImageUrl());
    }


    @GetMapping("/userByAuth0id")
    public UserDTO getUserById(@RequestParam String auth0id) {
        return userService.getUserById(auth0id);
    }
}
