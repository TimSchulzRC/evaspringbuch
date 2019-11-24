package de.evaspringbuch.eva08csrffront.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
    Optional<ChatUser> findByNickname(String nickname);
    boolean existsByNickname(String to);
}
