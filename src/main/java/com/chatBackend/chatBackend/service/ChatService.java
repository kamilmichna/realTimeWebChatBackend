package com.chatBackend.chatBackend.service;

import com.chatBackend.chatBackend.entity.Chat;
import com.chatBackend.chatBackend.entity.Role;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {
    private final ChatRepository chatRepo;

    public ChatService(ChatRepository chatRepo) {
        this.chatRepo = chatRepo;
    }

    public List<Chat> getAllChatsForUser() {

        return chatRepo.findAll();
    }

    public boolean createChat(Chat chat) {
        if (chat.getUsers().size() != 2) {
            return false;
        }

        chatRepo.save(chat);
        return true;
    }

}
