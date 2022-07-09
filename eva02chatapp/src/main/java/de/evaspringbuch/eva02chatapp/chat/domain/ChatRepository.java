package de.evaspringbuch.eva02chatapp.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    Optional<Chat> findByChatUser_NicknameAndChatWith(String from, String to);
}
