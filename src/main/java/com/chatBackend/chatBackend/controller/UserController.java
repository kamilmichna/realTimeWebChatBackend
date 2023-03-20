package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = this.userService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> onLoginCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/users/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public User newUser(@RequestBody User user) {
        return userService.createNewUser(user);
    }

}
