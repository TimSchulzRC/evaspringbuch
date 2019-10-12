package de.evaspringbuch.eva04howtodi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva04howtodi.service.ShowService;

@SpringBootApplication
public class Eva04p4HowtoDI {

//    private static final Logger log = LoggerFactory.getLogger(Eva04p4HowtoDI.class);

//    @Autowired
//    private ShowService showService;

    public static void main(String[] args) {
        SpringApplication.run(Eva04p4HowtoDI.class);
    }

//    @Bean
//    CommandLineRunner init() {
//        return (evt) -> {
//            ShowService showService = new ShowService();
//            showService.doSomething();
//        };
//    }

//
}
