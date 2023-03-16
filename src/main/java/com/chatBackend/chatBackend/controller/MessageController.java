package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.Message;
import com.chatBackend.chatBackend.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }
    @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getAllUsers() {
        try {
            List<Message> chats = this.messageService.findAll();
            return new ResponseEntity<>(chats, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
