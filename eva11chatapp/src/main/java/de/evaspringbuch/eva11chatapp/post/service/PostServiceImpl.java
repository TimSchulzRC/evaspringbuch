package de.evaspringbuch.eva11chatapp.post.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva11chatapp.chat.domain.Chat;
import de.evaspringbuch.eva11chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva11chatapp.chat.service.ChatService;
import de.evaspringbuch.eva11chatapp.chat.service.ChatUserService;
import de.evaspringbuch.eva11chatapp.post.domain.Post;
import de.evaspringbuch.eva11chatapp.post.service.dto.PayActionResponseDTO;
import de.evaspringbuch.eva11chatapp.post.service.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    private ChatUserService chatUserService;
    private ChatService chatService;
    private SmmpService smmpService;
    
    @Autowired
    public PostServiceImpl(ChatUserService chatUserService, ChatService chatService, SmmpService smmpService) {
        this.chatUserService = chatUserService;
        this.chatService = chatService;
        this.smmpService = smmpService;
    }

    @Override
    public List<PostDTO> listAllPostsFromTo(String from, String to) {
        ChatUser chatuserFrom = chatUserService.getByNickname(from);
        List<Post> targetListOrigin = new ArrayList<>(chatuserFrom.getChats().get(to).getPosts()); 
		List<PostDTO> targetList= new ArrayList<PostDTO>(); 
		for (Post source: targetListOrigin ) {
			PostDTO target= new PostDTO();
	        BeanUtils.copyProperties(source , target);    
	        targetList.add(target);
	    };
        chatService.resetNewPosts(from, to);
        return targetList;
    }

    @Override
    public void addPost(String from, String to, String pcontent) {
    	if ("smmp".equals(to)) {
            Chat chatFrom =  chatUserService.getChatFromByNicknameTo(to,from);
            chatService.savePosts(chatFrom, pcontent, "out");
            PayActionResponseDTO payActionResponse = smmpService.doPayAction(from, to, pcontent);
            chatService.savePosts(chatFrom, payActionResponse.getDescription(), "in");
            return;
        }
    	Chat chatFrom =  chatUserService.getChatFromByNicknameTo(to,from);
        Chat chatTo =  chatUserService.getChatFromByNicknameTo(from,to);
        if (chatTo != null) {
            chatService.savePosts(chatFrom, pcontent, "out");
            chatTo.addNewPosts();
            chatService.savePosts(chatTo, pcontent, "in");
        } else {
            chatService.savePosts(chatFrom, pcontent, "out");
            chatService.savePosts(chatFrom, "chat mit " + to + " ist gelöscht", "in");
        }
    }

}

