package de.evaspringbuch.eva08corsback.security.service.user;


import java.util.Collection;

import de.evaspringbuch.eva08corsback.security.domain.User;

public interface UserService {

    User getUserById(long id);

    User getUserByEmail(String email);

    boolean existsByNickname(String nickname);

    boolean existsByEmail(String email);

    Collection<User> getAllUsers();


}
