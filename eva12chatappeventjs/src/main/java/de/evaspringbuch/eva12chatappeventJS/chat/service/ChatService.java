package de.evaspringbuch.eva12chatappeventJS.chat.service;

import de.evaspringbuch.eva12chatappeventJS.chat.domain.Chat;
import de.evaspringbuch.eva12chatappeventJS.chat.domain.ChatUser;

public interface ChatService {

    void newChatBetween(ChatUser userTo, ChatUser userFrom);

    void deleteChatBetween(ChatUser userFrom, ChatUser userTo);

    void savePosts(Chat chat, String pcontent, String inOrOut);

    void resetNewPosts(String from, String to);
}
