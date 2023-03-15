package com.chatBackend.chatBackend.service;


import com.chatBackend.chatBackend.entity.Message;
import com.chatBackend.chatBackend.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;


    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> findAll(){
        return messageRepository.findAll();
    }
}
