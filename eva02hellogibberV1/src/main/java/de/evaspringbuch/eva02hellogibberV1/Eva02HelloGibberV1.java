package de.evaspringbuch.eva02hellogibberV1;

import de.evaspringbuch.eva02hellogibberV1.boundary.HelloController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


// first version
//@SpringBootApplication
//public class Eva02HelloGibberV1 {
//
//    private static final Logger log = LoggerFactory.getLogger(Eva02HelloGibberV1.class);
//
//    @Autowired
//    private HelloController helloController;
//    public static void main(String[] args) {
//        SpringApplication.run(Eva02HelloGibberV1.class);
//    }
//
//    @Bean
//    CommandLineRunner init() {
//        return (evt) -> log.debug(helloController.helloMessage("Hallo"));
//    }
//}

// second version
@SpringBootApplication
public class Eva02HelloGibberV1 {

	private static final Logger LOGGER = LoggerFactory.getLogger(Eva02HelloGibberV1.class);
    @Autowired
    private HelloController helloController;

    public static void main(String[] args) {
        SpringApplication.run(Eva02HelloGibberV1.class);
    }

  @Bean
  CommandLineRunner init() {
      return (evt) -> {
          LOGGER.debug(helloController.helloMessage("hallo"));
          LOGGER.debug(helloController.helloMessage("nochmal hallo"));
      };
  }
}
