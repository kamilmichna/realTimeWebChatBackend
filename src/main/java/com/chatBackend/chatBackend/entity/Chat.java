package com.chatBackend.chatBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Chats")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // getters and setters
}