package de.evaspringbuch.eva02chatapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva02chatapp.chat.domain.Chat;
import de.evaspringbuch.eva02chatapp.chat.domain.ChatRepository;
import de.evaspringbuch.eva02chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva02chatapp.chat.domain.ChatUserRepository;
import de.evaspringbuch.eva02chatapp.post.domain.Post;
import de.evaspringbuch.eva02chatapp.post.domain.PostRepository;

import javax.annotation.PostConstruct;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static java.time.format.DateTimeFormatter.ofLocalizedTime;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);


    @Autowired
    ChatUserRepository chatUserRepository;
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    PostRepository postRepository;

    @PostConstruct
    public void init()  {

            log.debug(" >>> Db initialized");

            ChatUser chatUser1 = new ChatUser();chatUser1.setNickname("elisa");
            ChatUser chatUser2 = new ChatUser();chatUser2.setNickname("marga");
            chatUserRepository.save(chatUser1);
            chatUserRepository.save(chatUser2);

            ChatUser chatUser3 = new ChatUser();chatUser3.setNickname("frieda");
            chatUserRepository.save(chatUser3);

            Chat chat1 = new Chat(chatUser2.getNickname(), chatUser1);
            Chat chat2 = new Chat(chatUser1.getNickname(), chatUser2);

            chatUser1.addChat(chat1);
            chatUser2.addChat(chat2);
            chatRepository.save(chat1);
            chatRepository.save(chat2);

            DateTimeFormatter germanFormatter =
                    ofLocalizedTime(FormatStyle.MEDIUM)
                            .withLocale(Locale.GERMAN);
            String s = LocalTime.now().minusMinutes(10).format(germanFormatter);

            Post p1 = new Post("Hallo Marga", s, chat1, "out");
            postRepository.save(p1);
            Post p2 = new Post("Hallo Marga", s, chat2, "in");
            postRepository.save(p2);
            chat1.addPosts(p1);
            chat2.addPosts(p2);

            s = LocalTime.now().minusMinutes(8).format(germanFormatter);

            Post p3 = new Post("Hi Elisa", s, chat1, "in");
            postRepository.save(p3);
            Post p4 = new Post("Hi Elisa", s, chat2, "out");
            postRepository.save(p4);
            chat1.addPosts(p3);
            chat2.addPosts(p4);

            chatRepository.save(chat1);
            chatRepository.save(chat2);

    }
}
