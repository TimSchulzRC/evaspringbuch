package de.evaspringbuch.eva08corsback.security.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);
    
    List<User> findAllByOrderByEmailAsc();
}
