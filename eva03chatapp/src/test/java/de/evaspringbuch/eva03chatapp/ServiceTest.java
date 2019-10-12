package de.evaspringbuch.eva03chatapp;

import static org.assertj.core.api.Assertions.assertThat;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.evaspringbuch.eva03chatapp.chat.domain.Chat;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatRepository;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUserRepository;
import de.evaspringbuch.eva03chatapp.chat.service.ChatService;
import de.evaspringbuch.eva03chatapp.chat.service.ChatUserService;
import de.evaspringbuch.eva03chatapp.post.domain.PostRepository;
import de.evaspringbuch.eva03chatapp.post.service.PostService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Eva03ChatApp.class)
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

    String elisa = "elisa", marga = "marga", unknown = "unknown", emptyUser = "";

    @Before
    public void setupDB() {
        System.out.println("tests are starting");
    }


    @Test
    @Transactional
    public void test_existsChatFromTo() {
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
