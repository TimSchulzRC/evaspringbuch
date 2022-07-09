package de.evaspringbuch.eva11chatapp.chat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva11chatapp.chat.domain.Chat;
import de.evaspringbuch.eva11chatapp.chat.domain.ChatRepository;
import de.evaspringbuch.eva11chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva11chatapp.post.domain.Post;

@Service
public class ChatServiceImpl implements ChatService {

    private static final Logger log = LoggerFactory.getLogger(ChatServiceImpl.class);

    private ChatRepository chatRepository;

    @Autowired
    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public void newChatBetween(ChatUser userTo, ChatUser userFrom) {
        Chat chat1 = new Chat(userTo.getNickname(), userFrom);
        Chat chat2 = new Chat(userFrom.getNickname(), userTo);
        if (userFrom.addChat(chat1)) chatRepository.save(chat1);
        if (userTo.addChat(chat2)) chatRepository.save(chat2);
    }

    @Override
    public void deleteChatBetween(ChatUser userFrom, ChatUser userTo) {
        String from = userFrom.getNickname();
        String to = userTo.getNickname();
//        Chat chat1 = userTo.getChats().get(from);
//        userTo.getChats().remove(from);
        Chat chat2 = userFrom.getChats().get(to);
        userFrom.getChats().remove(to);
//        chatRepository.delete(chat1);
        chatRepository.delete(chat2);
    }

    @Override
    public void savePosts(Chat chat, String pcontent, String inOrOut) {        
        Post post = new Post(pcontent, chat, inOrOut);
        chat.addPosts(post);
        chatRepository.save(chat);
    }

    @Override
    public void resetNewPosts(String from, String to) {
        chatRepository.findByChatUser_NicknameAndChatWith(from, to)
                .ifPresent(chat -> {
                    chat.resetNewPosts();
                    chatRepository.save(chat);
                    return;
                });
    }

}
