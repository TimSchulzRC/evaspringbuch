package de.evaspringbuch.eva08https.security.service.user;


import java.util.Collection;
import java.util.Optional;

import de.evaspringbuch.eva08https.security.domain.User;
import de.evaspringbuch.eva08https.security.domain.UserCreateForm;
import de.evaspringbuch.eva08https.security.service.dto.UserDTO;

public interface UserService {

	UserDTO getUserById(long id);
	Optional<User> getUserByEmail(String email);
    boolean existsByNickname(String nickname);
    boolean existsByEmail(String email);
    Collection<UserDTO> getAllUsers();
    User create(UserCreateForm form);

}
