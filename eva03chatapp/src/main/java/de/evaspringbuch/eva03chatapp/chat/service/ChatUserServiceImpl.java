package de.evaspringbuch.eva03chatapp.chat.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva03chatapp.chat.domain.Chat;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUserRepository;

@Service
public class ChatUserServiceImpl implements ChatUserService {

    private ChatUserRepository chatUserRepository;

    private ChatService chatService;

    @Autowired
    public ChatUserServiceImpl(ChatUserRepository chatUserRepository, ChatService chatService) {
        this.chatUserRepository = chatUserRepository;
        this.chatService = chatService;
    }

//    @Override
//    public void createChatUser(UserCreateForm form) {
//        ChatUser chatUser = new ChatUser();
//        chatUser.setNickname(form.getNickname());
//        chatUserRepository.save(chatUser);
//    }

    @Override
    public ChatUser getByNickname(String str) {
        return chatUserRepository.findByNickname(str).orElse(null);
    }

    @Override
    public Object exitsNickname(String to) {
        return chatUserRepository.findByNickname(to);
    }

    @Override
    public boolean chatUserChatsContainsKeyfindByNickname(String from, String to) {
    	Optional<ChatUser> userToOpt = chatUserRepository.findByNickname(from);
    	if (userToOpt.isPresent()) return userToOpt.get().getChats().containsKey(to);
    	return false;
    }

    @Override
    public void newChatFromTo(String from, String to) {
        ChatUser userFrom = chatUserRepository.findByNickname(from).orElse(null);
        ChatUser userTo = chatUserRepository.findByNickname(to).orElse(null);
        chatService.newChatBetween(userTo, userFrom);
    }

    @Override
    public void deleteChatFromTo(String from, String to) {
        ChatUser userFrom = chatUserRepository.findByNickname(from).orElse(null);
        ChatUser userTo = chatUserRepository.findByNickname(to).orElse(null);
        chatService.deleteChatBetween(userFrom, userTo);
    }

    @Override
    public Chat getChatFromByNicknameTo(String from, String to) {
    	Optional<ChatUser> userToOpt = chatUserRepository.findByNickname(to);
    	if (userToOpt.isPresent()) return userToOpt.get().getChats().get(from);
    	return null;
    }
}
