package com.example.ucuddit.mapper;

import com.example.ucuddit.dto.UserDTO;
import com.example.ucuddit.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "auth0id", target = "auth0id")
    @Mapping(source = "imageUrl", target = "imageUrl")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "auth0id", target = "auth0id")
    @Mapping(source = "imageUrl", target = "imageUrl")
    User userDTOToUser(UserDTO userDTO);
}