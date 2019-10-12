package de.evaspringbuch.eva03chatapp.chat.service;

import de.evaspringbuch.eva03chatapp.chat.domain.Chat;
import de.evaspringbuch.eva03chatapp.chat.domain.ChatUser;

public interface ChatService {

    void newChatBetween(ChatUser userTo, ChatUser userFrom);

    void deleteChatBetween(ChatUser userFrom, ChatUser userTo);

    void savePosts(Chat chat, String pcontent, String inOrOut);

    void resetNewPosts(String from, String to);
}
