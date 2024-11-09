package com.example.ucuddit.controller;
import com.example.ucuddit.model.Post;
import com.example.ucuddit.model.User;
import com.example.ucuddit.service.UserService;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/userByAuth0id")
    public User getUserById(@RequestParam String auth0id) {
        return userService.getUserById(auth0id);
    }
}
