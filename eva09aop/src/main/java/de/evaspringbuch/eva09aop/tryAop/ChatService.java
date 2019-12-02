package de.evaspringbuch.eva09aop.tryAop;

import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private Chat chat;

    public Chat getChat() {
		return this.chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Chat createChat(String name) {
        chat = new Chat();
        setChat(chat);
        return chat;
    }

	public Integer getId() {
		return this.chat.getId();
		
	}
}
