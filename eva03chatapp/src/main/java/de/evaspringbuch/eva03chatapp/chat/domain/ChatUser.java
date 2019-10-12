package de.evaspringbuch.eva03chatapp.chat.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
public class ChatUser implements Serializable {

    @Transient
    private static final Logger log = LoggerFactory.getLogger(ChatUser.class);

    @Id 
    @GeneratedValue
    private Integer id;

    private String nickname;

    @OneToMany(mappedBy = "chatUser", cascade = CascadeType.ALL)
    @MapKey(name= "chatWith")
    private Map<String, Chat> chats = new HashMap<>();

    public ChatUser() {
    }

    public Integer getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
                "id=" + id +
                "nickname=" + nickname +
                ", chats='" + chats +
                '}';
    }

}
