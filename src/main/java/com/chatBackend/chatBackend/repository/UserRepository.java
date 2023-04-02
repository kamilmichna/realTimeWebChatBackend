package com.chatBackend.chatBackend.repository;

import com.chatBackend.chatBackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {



    Optional<User> findByUsername(String username);

    @Query(
            nativeQuery = true,
            value = "select * from _user u \n" +
                    "left join users_chats uc\n" +
                    "on uc.user_username = u.username\n" +
                    "where u.username != ?1 and uc.user_username not in (\n" +
                    "    select distinct u.username from _user u\n" +
                    "    left join users_chats uc\n" +
                    "    on uc.user_username = u.username\n" +
                    "    where u.username != ?1 and uc.chat_id in \n" +
                    "    (\n" +
                    "    select distinct uc.chat_id from _user u\n" +
                    "        left join users_chats uc\n" +
                    "        on uc.user_username = u.username\n" +
                    "        where u.username = ?1\n" +
                    "    )\n" +
                    ") or uc.chat_id is null"
    )
    Optional<List<User>> findUnrelatedUsers(String username);
}