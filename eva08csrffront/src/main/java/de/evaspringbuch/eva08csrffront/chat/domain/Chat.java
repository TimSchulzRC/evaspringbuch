package de.evaspringbuch.eva08csrffront.chat.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import de.evaspringbuch.eva08csrffront.common.BaseEntity;
import de.evaspringbuch.eva08csrffront.post.domain.Post;

@Entity
public class Chat extends BaseEntity<Long> {

    private String chatWith;

    @ManyToOne
    private ChatUser chatUser;

    @OneToMany(mappedBy= "chat", cascade = CascadeType.ALL)
    private List<Post> posts;

    private int newPosts;

    public Chat() {}

    public Chat(String chatWith) {
        this.chatWith = chatWith;
        this.posts = new ArrayList<>();
    }

    public Chat(String chatWith, ChatUser chatUser) {
        this.posts = new ArrayList<>();
        this.chatWith = chatWith;
        this.chatUser = chatUser;
    }

    public String getChatWith() {
        return chatWith;
    }

    public void setChatWith(String chatWith) {
        this.chatWith = chatWith;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post post) {
        this.posts.add(post);
    }

    public ChatUser getChatUser() {
        return chatUser;
    }

    public int getNewPosts() {
        return newPosts;
    }

    public void addNewPosts() {
        this.newPosts++;
    }

    public void resetNewPosts() {
        this.newPosts = 0;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + getId() + " " +
                "chatWith=" + chatWith + " " +
                "owner=" + chatUser.getNickname()
                +
                '}';
    }

}
