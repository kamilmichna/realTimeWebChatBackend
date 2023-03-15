package com.chatBackend.chatBackend.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Chats")
public class Chat {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @OneToMany(mappedBy = "chat")
    private List<Message> messages;

    public Chat() {}
}