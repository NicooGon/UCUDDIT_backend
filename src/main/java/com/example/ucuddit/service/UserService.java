package com.example.ucuddit.service;
import com.example.ucuddit.model.User;
import com.example.ucuddit.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User checkOrCreateUser(String auth0id, String name, String email, String imageUrl) {
        User existingUser = userRepository.findByauth0id(auth0id);

        if (existingUser == null) {

            User newUser = new User();
            newUser.setAuth0id(auth0id);
            newUser.setName(name);
            newUser.setEmail(email);
            newUser.setImageUrl(imageUrl);
            return userRepository.save(newUser);
        }
        return existingUser;
    }
}
