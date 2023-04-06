package com.chatBackend.chatBackend.controller;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.Message;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/chats")
public class ChatsController {

    public final ChatService chatService;

    public ChatsController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    Set<Chat> getChatsForUser(Authentication authentication) {
        User userDetails = (User) authentication.getPrincipal();
        return userDetails.getChats();
    }

    @PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity register(@RequestBody Chat chat){
        return ResponseEntity.ok(chatService.createChat(chat));
    }

    @GetMapping("/{chatId}/messages")
    Set<Message> getMessagesForChat(@PathVariable(value="chatId") Integer id) {
        return chatService.getMessagesInChat(id);
    }
}
