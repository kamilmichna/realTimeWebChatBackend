package com.chatBackend.chatBackend.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @GetMapping(path = "/chats", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllChats() {
        return "All chats";
    }

    @GetMapping(path = "/chats/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getChatData(@PathVariable(value="id") String id) {
        return id;
    }
}
