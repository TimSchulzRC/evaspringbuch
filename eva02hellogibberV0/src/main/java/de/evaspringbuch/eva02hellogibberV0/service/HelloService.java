package de.evaspringbuch.eva02hellogibberV0.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
    private String myMessage;

    public String getMyMessage() {
        return myMessage;
    }

    public String setMyMessage(String message) {
        this.myMessage = message;
        return message;
    }
}
