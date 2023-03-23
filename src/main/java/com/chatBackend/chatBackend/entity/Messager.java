package com.chatBackend.chatBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Messager {
    @Id
    String username;
    String password;
}
