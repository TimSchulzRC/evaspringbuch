package de.evaspringbuch.eva02chatapp.post.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import de.evaspringbuch.eva02chatapp.chat.domain.Chat;

@Entity
public class Post {

    @Id 
    @GeneratedValue
    private Integer id;

    private String content;

    private String timestamp;

    private String type;

    public Post() {
        this.content = "";
        this.timestamp = "";
        this.type = "";
    }

    public Post(String content, String timestamp, Chat chat, String type) {
        this.content = content;
        this.timestamp = timestamp;
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }
}
