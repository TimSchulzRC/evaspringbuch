package de.evaspringbuch.eva03chatapp.chat.domain;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Integer> {
	Optional<ChatUser> findByNickname(String nickname);

//    @Query("select c from ChatUser c where c.nickname = ?1")
//    ChatUser findByNicknameQuery(String nickname);
}
