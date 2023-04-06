package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.service.UserService;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/login")
    HttpStatus login(){
        return HttpStatus.OK;
    }

    @PostMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping
    @Transactional
    Optional<List<User>> getAll(Authentication authentication) {
        User userDetails = (User) authentication.getPrincipal();
        Optional<List<User>> users = userService.getUsersAvailableToChat(userDetails);

        users.ifPresent(userList -> {
            for (User user : userList) {
                Hibernate.initialize(user.getChats());

                for (Chat chat : user.getChats()) {
                    Hibernate.initialize(chat.getMessages());
                }
            }
        });

        return users;
    }
    }
