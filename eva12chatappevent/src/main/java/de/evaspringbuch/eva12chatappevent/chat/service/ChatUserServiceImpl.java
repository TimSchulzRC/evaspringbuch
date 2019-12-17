package de.evaspringbuch.eva12chatappevent.chat.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.evaspringbuch.eva12chatappevent.chat.domain.Chat;
import de.evaspringbuch.eva12chatappevent.chat.domain.ChatUser;
import de.evaspringbuch.eva12chatappevent.chat.domain.ChatUserRepository;
import de.evaspringbuch.eva12chatappevent.chat.service.dto.ChatDTO;
import de.evaspringbuch.eva12chatappevent.security.domain.UserCreateForm;

@Service
public class ChatUserServiceImpl implements ChatUserService {

    private ChatUserRepository chatUserRepository;

    private ChatService chatService;

    @Autowired
    public ChatUserServiceImpl(ChatUserRepository chatUserRepository, ChatService chatService) {
        this.chatUserRepository = chatUserRepository;
        this.chatService = chatService;
    }

    @Override
    public void createChatUser(UserCreateForm form) {
        ChatUser chatUser = new ChatUser();
        chatUser.setNickname(form.getNickname());
        chatUserRepository.save(chatUser);
    }

    @Override
    public ChatUser getByNickname(String str) {
        return chatUserRepository.findByNickname(str).orElse(null);
    }

    @Override
    public boolean existsNickname(String to) {
        return chatUserRepository.existsByNickname(to);
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

	@Override
	public List<ChatDTO> getAllChatFrom(String from) {
		ChatUser userFrom = getByNickname(from);
		List<Chat> targetListOrigin = new ArrayList<>(userFrom.getChats().values()); 
		List<ChatDTO> targetList= new ArrayList<ChatDTO>(); 
		for (Chat source: targetListOrigin ) {
	        ChatDTO target= new ChatDTO();
	        BeanUtils.copyProperties(source , target);    
	        targetList.add(target);
	    };
		Collections.sort(targetList, new Comparator<ChatDTO>() {
		    public int compare(ChatDTO o1, ChatDTO o2) {
		           return o1.getChatWith().compareTo(o2.getChatWith());
		}});		
		return targetList;
	}
		
}
