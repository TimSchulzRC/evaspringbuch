package de.evaspringbuch.eva03chatapp.chat.service;

import de.evaspringbuch.eva03chatapp.chat.domain.Chat;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUser;

public interface ChatUserService {

    ChatUser getByNickname(String str);

    Object exitsNickname(String to);

    boolean chatUserChatsContainsKeyfindByNickname(String from, String to);

    void newChatFromTo(String from, String to);

    void deleteChatFromTo(String from, String to);

    Chat getChatFromByNicknameTo(String from, String to);
}
