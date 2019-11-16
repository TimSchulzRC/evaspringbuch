package de.evaspringbuch.eva07chatapp.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva07chatapp.chat.domain.Chat;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatRepository;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatUserRepository;
import de.evaspringbuch.eva07chatapp.post.domain.Post;
import de.evaspringbuch.eva07chatapp.post.domain.PostRepository;
import de.evaspringbuch.eva07chatapp.security.domain.Role;
import de.evaspringbuch.eva07chatapp.security.domain.User;
import de.evaspringbuch.eva07chatapp.security.domain.UserRepository;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);


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

        log.debug("Db initialized");

        User user = new User();
        user.setNickname("elisa");
        user.setEmail("el@a");
        user.setPassword("demo");
        user.setRole(Role.ADMIN);
        userRepository.save(user);

        user = new User();
        user.setNickname("marga");
        user.setEmail("ma@a");
        user.setPassword("demo");
        user.setRole(Role.USER);
        userRepository.save(user);

        user = new User();
        user.setNickname("frieda");
        user.setEmail("fr@a");
        user.setPassword("demo");
        user.setRole(Role.USER);
        userRepository.save(user);

        ChatUser chatUser1 = new ChatUser();chatUser1.setNickname("elisa");
        ChatUser chatUser2 = new ChatUser();chatUser2.setNickname("marga");
        chatUserRepository.save(chatUser1);
        chatUserRepository.save(chatUser2);

        ChatUser chatUser3 = new ChatUser();chatUser3.setNickname("frieda");
        chatUserRepository.save(chatUser3);

        Chat chat1 = new Chat(chatUser2.getNickname(), chatUser1);
        Chat chat2 = new Chat(chatUser1.getNickname(), chatUser2);
        Chat chat3 = new Chat(chatUser3.getNickname(), chatUser1);
        Chat chat4 = new Chat(chatUser1.getNickname(), chatUser3);
 
        chatUser1.addChat(chat1);
        chatUser2.addChat(chat2);
        chatUser1.addChat(chat3);
        chatUser3.addChat(chat4);
        chatRepository.save(chat1);
        chatRepository.save(chat2);
        chatRepository.save(chat3);
        chatRepository.save(chat4);

//        DateTimeFormatter germanFormatter =
//                ofLocalizedTime(FormatStyle.MEDIUM)
//                        .withLocale(Locale.GERMAN);
//        String s = LocalTime.now().minusMinutes(10).format(germanFormatter);

        Post p1 = new Post("Hallo Marga", chat1, "out");
        postRepository.save(p1);
        Post p2 = new Post("Hallo Marga", chat2, "in");
        postRepository.save(p2);
        chat1.addPosts(p1);
        chat2.addPosts(p2);

//        s = LocalTime.now().minusMinutes(8).format(germanFormatter);

        Post p3 = new Post("Hi Elisa", chat1, "in");
        postRepository.save(p3);
        Post p4 = new Post("Hi Elisa", chat2, "out");
        postRepository.save(p4);
        chat1.addPosts(p3);
        chat2.addPosts(p4);

    }
}
