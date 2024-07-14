package com.example.spoticloudspringdata.services;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.repositories.implementations.UserRepository;
import com.example.spoticloudspringdata.schemas.UserCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public User createUser(UserCreate user) {
        User newUser = new User(user.getUsername(), user.getEmail(), user.getPassword());
        return userRepository.save(newUser);
    }



    public void deleteUser(User user) {
        user.setDeleted(true);
        userRepository.save(user);
    }

    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        user.setDeleted(true);
        userRepository.save(user);
    }
}
