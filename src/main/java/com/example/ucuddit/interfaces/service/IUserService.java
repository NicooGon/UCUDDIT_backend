package com.example.ucuddit.interfaces.service;

import com.example.ucuddit.dto.UserDTO;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.UserRepository;

public interface IUserService{

    UserDTO getUserById(String auth0id);
    UserDTO checkOrCreateUser(String auth0id, String name, String email, String imageUrl);
}
