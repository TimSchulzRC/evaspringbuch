package de.evaspringbuch.eva12chatappevent.post.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

import de.evaspringbuch.eva12chatappevent.chat.domain.ChatUser;
import de.evaspringbuch.eva12chatappevent.chat.service.ChatUserService;
import de.evaspringbuch.eva12chatappevent.post.domain.Post;
import de.evaspringbuch.eva12chatappevent.post.domain.PostRepository;

@Component
public class PostReadListener { 
  
	private static final Logger LOGGER = LoggerFactory.getLogger(PostReadListener.class);
	
	private PostRepository postRepository;
    private ChatUserService chatUserService;
	
	@Autowired
	public PostReadListener(PostRepository postRepository, ChatUserService chatUserService) {
		this.postRepository = postRepository;
		this.chatUserService = chatUserService;
	}

	@EventListener
    public void handlePostReadEvent(PostReadEvent event) {
		String from= event.getFrom();
		String to = event.getTo();
		
		ChatUser chatuserFrom = chatUserService.getByNickname(to);
        List<Post> targetListOrigin = new ArrayList<>(chatuserFrom.getChats().get(from).getPosts()); 
		targetListOrigin.forEach(p -> {
        	if (p.getType().equals("out") && p.getRead().equals("nein")) {
        		p.setRead("ja");
        		postRepository.save(p);
        	}
        });


	}	
}
