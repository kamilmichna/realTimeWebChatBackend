package com.chatBackend.chatBackend.service;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.Message;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.repository.MessageRepository;
import com.chatBackend.chatBackend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.Authenticator;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Optional<List<Message>> getAllMessages() {
        return Optional.of(messageRepository.findAll());
    }

    public boolean createMessage(@RequestBody Message message, Authentication auth) {
        User userDetail = (User) auth.getPrincipal();
        message.setUser(userDetail);
        messageRepository.save(message);
        return true;
    }
}
