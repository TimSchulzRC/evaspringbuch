package de.evaspringbuch.eva02hellogibberV1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva02hellogibberV1.service.HelloService;



// first version
@SpringBootApplication
public class Eva02HelloGibberV1 {

    @Autowired
    private HelloService helloService;

    public static void main(String[] args) {
        SpringApplication.run(Eva02HelloGibberV1.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
            System.out.println(helloService.setMyMessage("Hallo Welt"));
            System.out.println(helloService.getMyMessage());
            System.out.println(helloService.setMyMessage("Hallo lass uns quatschen"));
            System.out.println(helloService.getMyMessage());
        };
    }
}

// second version
//@SpringBootApplication
//public class eva02HelloGibberV1 {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(eva02HelloGibberV1.class);
//    @Autowired
//    private HelloController helloController;
//
//    public static void main(String[] args) {
//        SpringApplication.run(eva02HelloGibberV1.class);
//    }
//
//  @Bean
//  CommandLineRunner init() {
//      return (evt) -> {
//          LOGGER.debug(helloController.helloMessage("hallo"));
//          LOGGER.debug(helloController.helloMessage("nochmal hallo"));
//      };
//  }
//}
