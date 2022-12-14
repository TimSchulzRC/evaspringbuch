package de.evaspringbuch.eva07chatapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import de.evaspringbuch.eva07chatapp.chat.domain.Chat;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatRepository;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatUserRepository;
import de.evaspringbuch.eva07chatapp.chat.service.ChatService;
import de.evaspringbuch.eva07chatapp.chat.service.ChatUserService;
import de.evaspringbuch.eva07chatapp.post.domain.PostRepository;
import de.evaspringbuch.eva07chatapp.post.service.PostService;
import de.evaspringbuch.eva07chatapp.security.domain.UserRepository;


@SpringBootTest //(classes = Eva07ChatAppUIadvanced.class)
public class ServiceTest {

    @Autowired
    ChatUserRepository chatUserRepository;
    @Autowired
    ChatRepository chatRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    ChatUserService chatUserService;
    @Autowired
    ChatService chatService;
    @Autowired
    PostService postService;

    @Autowired
    UserRepository userRepository;

    String elisa = "elisa", marga = "marga", unknown = "unknown", emptyUser = "";

    @BeforeEach
    public void setupDB() {
    }

    @Test
    @Transactional
    public void test_newChatFromTo() {
       Chat chat = chatUserService.getChatFromByNicknameTo(elisa, marga);
        assertThat(chat.getChatUser().getNickname()).isEqualTo(marga);


    }

    @Test
    @Transactional
    public void test_new2ChatFromTo() {
        Chat chat = chatUserService.getChatFromByNicknameTo(marga, elisa);
        assertThat(chat.getChatUser().getNickname()).isEqualTo(elisa);


    }


}
