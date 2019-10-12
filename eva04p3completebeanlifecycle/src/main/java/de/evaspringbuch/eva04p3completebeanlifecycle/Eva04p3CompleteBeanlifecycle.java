package de.evaspringbuch.eva04p3completebeanlifecycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva04p3completebeanlifecycle.service.CompleteService;

@SpringBootApplication
public class Eva04p3CompleteBeanlifecycle {

    @Autowired private CompleteService completeService;

    public static void main(String[] args) {
        SpringApplication.run(Eva04p3CompleteBeanlifecycle.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
            completeService.doSomething();
        };
    }

//
}
