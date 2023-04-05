package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.Message;
import com.chatBackend.chatBackend.service.MessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {
    public final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    Optional<List<Message>> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity register(@RequestBody Message mess, Authentication auth) {
        return ResponseEntity.ok(messageService.createMessage(mess,auth));
    }

}
