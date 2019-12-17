package de.evaspringbuch.eva12chatappevent.post.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;

import de.evaspringbuch.eva12chatappevent.chat.domain.Chat;
import de.evaspringbuch.eva12chatappevent.common.BaseEntity;

@Entity
@EntityListeners(PostListener.class)
public class Post extends BaseEntity<Long> {

    private String content;

    private String timestamp;

    private String type;
    
    private String read = "";

    @ManyToOne
    private Chat chat;

    public Post() {
        this.content = "";
        this.timestamp = "";
        this.type = "";
        this.chat = new Chat();
    }
    
    public Post(String content, Chat chat, String type) {
        this.content = content;
        this.type = type;
        this.chat = chat;
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

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}
    
}
