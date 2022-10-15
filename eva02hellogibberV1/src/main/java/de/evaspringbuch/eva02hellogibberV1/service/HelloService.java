package de.evaspringbuch.eva02hellogibberV1.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

    private String myMessage;
    private int count = 0;

    public int inc () {
        return ++count;
    }

    public String getMyMessage() {
        return myMessage;
    }

    public String setMyMessage(String message) {
        this.myMessage = message;
        return message;
    }
    
}
