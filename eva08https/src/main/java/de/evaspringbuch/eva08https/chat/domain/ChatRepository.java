package de.evaspringbuch.eva08https.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findByChatUser_NicknameAndChatWith(String from, String to);
}
