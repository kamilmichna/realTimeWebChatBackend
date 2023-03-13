package com.chatBackend.chatBackend.entity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Expose
    @SerializedName("id")
    private Long id;

    @Expose
    private String username;
    private String password;

    @Expose
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "joined_at", nullable = false)
    private Date joinedAt;

    @PrePersist
    protected void onCreate() {
        joinedAt = new Date();
    }

}