package de.evaspringbuch.eva12chatappeventJS.chat.service;

import java.util.List;

import de.evaspringbuch.eva12chatappeventJS.chat.domain.Chat;
import de.evaspringbuch.eva12chatappeventJS.chat.domain.ChatUser;
import de.evaspringbuch.eva12chatappeventJS.chat.service.dto.ChatDTO;
import de.evaspringbuch.eva12chatappeventJS.security.domain.UserCreateForm;

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
