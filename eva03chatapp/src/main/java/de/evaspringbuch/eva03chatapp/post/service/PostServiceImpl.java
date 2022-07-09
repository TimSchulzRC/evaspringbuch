package de.evaspringbuch.eva03chatapp.post.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva03chatapp.chat.domain.Chat;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva03chatapp.chat.service.ChatService;
import de.evaspringbuch.eva03chatapp.chat.service.ChatUserService;
import de.evaspringbuch.eva03chatapp.post.domain.Post;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    private ChatUserService chatUserService;
    private ChatService chatService;

    @Autowired
    public PostServiceImpl(ChatUserService chatUserService, ChatService chatService) {
        this.chatUserService = chatUserService;
        this.chatService = chatService;
    }

    @Override
    public List<Post> listAllPostsFromTo(String from, String to) {
        ChatUser chatuserFrom = chatUserService.getByNickname(from);
        chatService.resetNewPosts(from, to);
        return chatuserFrom.getChats().get(to).getPosts();
    }

    @Override
    public void addPost(String from, String to, String pcontent) {
        Chat chatFrom =  chatUserService.getChatFromByNicknameTo(to,from);
        Chat chatTo =  chatUserService.getChatFromByNicknameTo(from,to);
        if (chatTo != null) {
            chatService.savePosts(chatFrom, pcontent, "out");
            chatTo.addNewPosts();
            chatService.savePosts(chatTo, pcontent, "in");
        } else {
            chatService.savePosts(chatFrom, pcontent, "out");
            chatService.savePosts(chatFrom, "chat mit " + to + " ist geloescht", "in");
        }
    }

}

