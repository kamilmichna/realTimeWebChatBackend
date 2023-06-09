package com.chatBackend.chatBackend.service;

import com.chatBackend.chatBackend.entity.Role;
import com.chatBackend.chatBackend.entity.User;
import com.chatBackend.chatBackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public boolean register(User user) {
        String username = user.getUsername();
        boolean isUserAlreadyRegistered = !userRepo.findByUsername(username).isEmpty();
        if (isUserAlreadyRegistered) {
            return false;
        }
        User newUser = User.builder().username(user.getUsername()).password(user.getPassword()).role(Role.USER).build();
        userRepo.save(newUser);
        return true;
    }

    public Optional<List<User>> getUsersAvailableToChat(User user) {
        if (user.getChats().size() == 0) {
            return Optional.of(userRepo.findAll());
        }
        return userRepo.findUnrelatedUsers(user.getUsername());
    }
}
