package de.evaspringbuch.eva07chatapp.chat.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {

    Optional<Chat> findByChatUser_NicknameAndChatWith(String from, String to);
}
