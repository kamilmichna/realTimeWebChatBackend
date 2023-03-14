package com.chatBackend.chatBackend.entity;

import jakarta.persistence.*;

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

    public Chat() {}
}