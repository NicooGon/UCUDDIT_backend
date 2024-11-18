package com.example.ucuddit.service;
import com.example.ucuddit.dto.UserDTO;
import com.example.ucuddit.interfaces.service.IUserService;
import com.example.ucuddit.mapper.UserMapper;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    private static final UserMapper userMapper = UserMapper.INSTANCE;

    public UserDTO getUserById(String auth0id) {
        User user = userRepository.findByauth0id(auth0id);
        return userMapper.userToUserDTO(user);
    }

    public UserDTO userNative() {
        String auth0id = "google-oauth2|101483569146996195106";

        User user = userRepository.findByauth0id(auth0id);

        if (user == null) {

            return null;
        }
        return userMapper.userToUserDTO(user);
    }

    public UserDTO checkOrCreateUser(String auth0id, String name, String email, String imageUrl) {
        User existingUser = userRepository.findByauth0id(auth0id);

        if (existingUser == null) {

            User newUser = new User();
            newUser.setAuth0id(auth0id);
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setImageUrl(imageUrl);
            userRepository.save(newUser);
            return userMapper.userToUserDTO(newUser);
        }
        return userMapper.userToUserDTO(existingUser);
    }
}
