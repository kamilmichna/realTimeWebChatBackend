package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path = "/register")
    ResponseEntity register(@RequestBody User user){
        return ResponseEntity.ok(userService.register(user));
    }

    @GetMapping
    List<User> getAll() {
        return userService.getAllUsers();
    }
}
