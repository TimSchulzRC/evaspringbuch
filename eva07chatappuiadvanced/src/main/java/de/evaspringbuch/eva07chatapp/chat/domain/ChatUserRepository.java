package de.evaspringbuch.eva07chatapp.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {
    Optional<ChatUser> findByNickname(String nickname);
    boolean existsByNickname(String to);
}
