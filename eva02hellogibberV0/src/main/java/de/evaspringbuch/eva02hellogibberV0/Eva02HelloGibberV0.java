package de.evaspringbuch.eva02hellogibberV0;

import de.evaspringbuch.eva02hellogibberV0.service.HelloService;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class Eva02HelloGibberV0 {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Eva02HelloGibberV0.class);

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(Eva02HelloGibberV0.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
                System.out.println(helloService.setMyMessage("Hallo Welt"));
                System.out.println(helloService.getMyMessage());
                System.out.println(helloService.setMyMessage("Hallo, lass uns quatschen!"));
                System.out.println(helloService.getMyMessage());
            };
        }
}

