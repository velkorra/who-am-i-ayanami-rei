package com.example.spoticloudspringdata.controllers;

import com.example.spoticloudspringdata.entities.User;
import com.example.spoticloudspringdata.schemas.UserCreate;
import com.example.spoticloudspringdata.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userService.getByUsername(username);
    }

    @PostMapping
    public User createUser(@RequestBody UserCreate user){
        return userService.createUser(user);
    }
}
