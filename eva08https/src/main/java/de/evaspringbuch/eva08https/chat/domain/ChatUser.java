package de.evaspringbuch.eva08https.chat.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import de.evaspringbuch.eva08https.common.BaseEntity;

@Entity
public class ChatUser extends BaseEntity<Long> {

    private String nickname;

    private ChatType chatType = ChatType.Normal;

    @OneToMany(mappedBy = "chatUser", cascade = CascadeType.ALL)
    @MapKey(name= "chatWith")
    private Map<String, Chat> chats = new HashMap<>();

    public ChatUser() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ChatType getChatType() {
        return chatType;
    }

    public void setChatType(ChatType chatType) {
        this.chatType = chatType;
    }

    public Map<String, Chat> getChats() {
        return chats;
    }

    public void setChats(Map<String, Chat> chats) {
        this.chats = chats;
    }

    public boolean addChat(Chat chat) {
        if (this.chats == null) {
            this.chats = new HashMap<>(); return true;
        }
        else {
            if (!this.chats.containsKey(chat.getChatWith())) {
                this.chats.put(chat.getChatWith(), chat);
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return "ChatUser{" +
                "id=" + getId() +
                "nickname=" + nickname +
                ", chats='" + chats +
                '}';
    }

}
