package com.chatBackend.chatBackend.repository;

import com.chatBackend.chatBackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {
}
