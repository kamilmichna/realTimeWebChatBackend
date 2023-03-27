package com.chatBackend.chatBackend.repository;

import com.chatBackend.chatBackend.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat,Integer> {
}
