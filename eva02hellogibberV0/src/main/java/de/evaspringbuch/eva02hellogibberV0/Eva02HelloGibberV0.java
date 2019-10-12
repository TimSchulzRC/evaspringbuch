package de.evaspringbuch.eva02hellogibberV0;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Eva02HelloGibberV0 {

    public static void main(String[] args) {
        SpringApplication.run(Eva02HelloGibberV0.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> System.out.println("Hallo Welt");
    }

}
