package com.example.ucuddit.interfaces.service;

import com.example.ucuddit.dto.UserDTO;

public interface IUserService{

    UserDTO getUserById(String auth0id);
    UserDTO userNative();
    UserDTO checkOrCreateUser(String auth0id, String name, String email, String imageUrl);
}
