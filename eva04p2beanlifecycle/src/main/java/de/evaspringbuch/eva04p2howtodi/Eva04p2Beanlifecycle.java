package de.evaspringbuch.eva04p2howtodi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva04p2howtodi.service.SmallService;

@SpringBootApplication
public class Eva04p2Beanlifecycle {

//    private static final Logger log = LoggerFactory.getLogger(Eva04p2Beanlifecycle.class);

    @Autowired private SmallService smallService;

    public static void main(String[] args) {
        SpringApplication.run(Eva04p2Beanlifecycle.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
            smallService.doSomething();
        };
    }

//
}
