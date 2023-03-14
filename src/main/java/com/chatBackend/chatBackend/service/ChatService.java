package com.chatBackend.chatBackend.service;


import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private  final ChatRepository chatRepository;


    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<Chat> findAll(){
        return chatRepository.findAll();
    }
}
