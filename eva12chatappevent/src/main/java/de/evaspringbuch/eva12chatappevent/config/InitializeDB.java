package de.evaspringbuch.eva12chatappevent.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva12chatappevent.chat.domain.*;
import de.evaspringbuch.eva12chatappevent.post.domain.Post;
import de.evaspringbuch.eva12chatappevent.post.domain.PostRepository;
import de.evaspringbuch.eva12chatappevent.security.domain.Role;
import de.evaspringbuch.eva12chatappevent.security.domain.User;
import de.evaspringbuch.eva12chatappevent.security.domain.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Component
public class InitializeDB {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired
    ChatUserRepository chatUserRepository;
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init()  {

        LOGGER.debug("Db initialized");
        
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User user = new User();
        user.setNickname("elisa");
        user.setEmail("el@a");
        user.setPasswordHash(passwordEncoder.encode("demo"));
     
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        user = new User();
        user.setNickname("marga");
        user.setEmail("ma@a");
        user.setPasswordHash(passwordEncoder.encode("demo"));
        user.setRole(Role.USER);
        userRepository.save(user);

        user = new User();
        user.setNickname("frieda");
        user.setEmail("fr@a");
        user.setPasswordHash(passwordEncoder.encode("demo"));
        user.setRole(Role.USER);
        userRepository.save(user);

        ChatUser chatUser1 = new ChatUser();chatUser1.setNickname("elisa");
        ChatUser chatUser2 = new ChatUser();chatUser2.setNickname("marga");
        chatUserRepository.save(chatUser1);
        chatUserRepository.save(chatUser2);

        ChatUser chatUser3 = new ChatUser();chatUser3.setNickname("frieda");
        chatUserRepository.save(chatUser3);
        
        ChatUser chatBot = new ChatUser();chatBot.setNickname("smmp");chatBot.setChatType(ChatType.Bot);
        chatUserRepository.save(chatBot);

        Chat chat1 = new Chat(chatUser2.getNickname(), chatUser1);
        Chat chat2 = new Chat(chatUser1.getNickname(), chatUser2);
        Chat chat3 = new Chat(chatBot.getNickname(), chatUser1);
        Chat chat4 = new Chat(chatUser1.getNickname(), chatBot);
    
        chatUser1.addChat(chat1);
        chatUser1.addChat(chat3);
        chatUser2.addChat(chat2);
        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
    
        Post p1 = new Post("Hallo Marga", chat1, "out");
        postRepository.save(p1);
        Post p2 = new Post("Hallo Marga", chat2, "in");
        postRepository.save(p2);
        chat1.addPosts(p1);
        chat2.addPosts(p2);

        Post p3 = new Post("Hi Elisa", chat1, "in");
        postRepository.save(p3);
        Post p4 = new Post("Hi Elisa", chat2, "out");
        postRepository.save(p4);
        chat1.addPosts(p3);
        chat2.addPosts(p4);

    }
}
