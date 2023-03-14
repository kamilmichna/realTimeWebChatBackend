package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.service.ChatService;
import com.chatBackend.chatBackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping(path = "/chats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Chat>> getAllUsers() {
        try {
            List<Chat> chats = this.chatService.findAll();
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
