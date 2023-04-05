package com.chatBackend.chatBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Message {
    @Id
    @GeneratedValue
    private Integer id;

    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_username", nullable = false)
    private User user;

    @CreationTimestamp
    private Timestamp sendTime;
}
