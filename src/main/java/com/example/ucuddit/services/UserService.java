package com.example.ucuddit.services;

import com.example.ucuddit.models.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User(
                        1,
                        1,
                        "nico",
                        "nico@gmail.com"
                )
        );
    }
}
