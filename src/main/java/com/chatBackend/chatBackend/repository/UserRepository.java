package com.chatBackend.chatBackend.repository;

import com.chatBackend.chatBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {



    Optional<User> findByUsername(String username);
}