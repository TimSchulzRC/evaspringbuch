package de.evaspringbuch.eva02hellogibberV1.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva02hellogibberV1.service.HelloService;

@Component
public class HelloController {

    @Autowired
    private HelloService helloService;

    public String helloMessage(String message) {
        return helloService.setMyMessage(" na sowas :: " + message);
    }
}
