package de.evaspringbuch.eva08corsback.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva08corsback.security.domain.Role;
import de.evaspringbuch.eva08corsback.security.domain.User;
import de.evaspringbuch.eva08corsback.security.domain.UserRepository;

@Component
public class InitializeDB {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init()  {

        LOGGER.debug("Db initialized");

        User user = new User();
        user.setNickname("elisa");
        user.setEmail("el@a");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("demo"));
        
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        user = new User();
        user.setNickname("marga");
        user.setEmail("ma@a");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("demo"));
        user.setRole(Role.USER);
        userRepository.save(user);

        user = new User();
        user.setNickname("frieda");
        user.setEmail("fr@a");
        user.setPasswordHash(new BCryptPasswordEncoder().encode("demo"));
        user.setRole(Role.USER);
        userRepository.save(user);

    }
}
