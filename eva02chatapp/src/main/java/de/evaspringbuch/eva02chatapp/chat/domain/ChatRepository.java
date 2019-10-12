package de.evaspringbuch.eva02chatapp.chat.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Integer> {

    Optional<Chat> findByChatUser_NicknameAndChatWith(String from, String to);
}
