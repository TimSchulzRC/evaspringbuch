package de.evaspringbuch.eva02hellogibberV0.boundary;

import de.evaspringbuch.eva02hellogibberV0.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloController {

    @Autowired
    private HelloService helloService;

    public String helloMessage(String message) {
        return helloService.setMyMessage("na sowas :: " + message);
    }
}
