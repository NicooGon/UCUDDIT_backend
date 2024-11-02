package com.example.ucuddit.controller;
import com.example.ucuddit.model.User;
import com.example.ucuddit.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User checkOrCreateUser(@RequestBody User user) {
        return userService.checkOrCreateUser(user.getAuth0id(), user.getName(), user.getEmail(), user.getImageUrl());
    }
}
