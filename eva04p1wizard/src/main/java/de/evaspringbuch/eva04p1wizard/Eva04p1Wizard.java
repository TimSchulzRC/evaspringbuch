package de.evaspringbuch.eva04p1wizard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva04p1wizard.v1instantiating.WizardV1;


@SpringBootApplication
public class Eva04p1Wizard {

//    private static final Logger log = LoggerFactory.getLogger(Eva04p1Wizard.class);

    @Autowired private WizardV1 wizard;
//    @Autowired private WizardV3 wizard; 

    public static void main(String[] args) {
        SpringApplication.run(Eva04p1Wizard.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {

//            //v1instantiating
            wizard.performMagicTrick();

            //v2setter
//        	WizardV2 wizard = new WizardV2 ();
//            wizard.set(new Assistant(),new PackOfCards());
//            wizard.performMagicTrick();



//            //v3autowired
//        	wizard.performMagicTrick();
        };
    }

//
}
