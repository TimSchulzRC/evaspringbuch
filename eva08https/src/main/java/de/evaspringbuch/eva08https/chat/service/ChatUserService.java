package de.evaspringbuch.eva08https.chat.service;

import java.util.List;

import de.evaspringbuch.eva08https.chat.domain.Chat;
import de.evaspringbuch.eva08https.chat.domain.ChatUser;
import de.evaspringbuch.eva08https.chat.service.dto.ChatDTO;
import de.evaspringbuch.eva08https.security.domain.UserCreateForm;

public interface ChatUserService {

    void createChatUser(UserCreateForm form);

    ChatUser getByNickname(String str);

    boolean existsNickname(String to);

    boolean chatUserChatsContainsKeyfindByNickname(String from, String to);

    void newChatFromTo(String from, String to);

    void deleteChatFromTo(String from, String to);

    Chat getChatFromByNicknameTo(String from, String to);

	List<ChatDTO> getAllChatFrom(String from);
}
