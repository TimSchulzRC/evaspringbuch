package de.evaspringbuch.eva06smarthomeadvanced;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva06smarthomeadvanced.advanced.service.InitializeService;
import de.evaspringbuch.eva06smarthomeadvanced.advanced.service.InitializeWithInheritanceService;

@SpringBootApplication
public class Eva06SmartHomeAdvanced {

//    private static final Logger log = LoggerFactory.getLogger(Eva06SmartHomeAdvanced.class);

    @Autowired
    InitializeService initializeService;

    @Autowired
    InitializeWithInheritanceService initializeWithInheritanceService;

    public static void main(String[] args) {
        SpringApplication.run(Eva06SmartHomeAdvanced.class);
    }
    
    @Bean
    CommandLineRunner init() {
        return (evt) -> {
        	// start here with the first two initialize

        	initializeService.initMichael();
        	initializeService.initLaura();
        	
        	
//          initializeService.initToni();
//          initializeService.initKarl();
//          initializeService.initAnna();

//          initializeService.tryDeleteBuilding();   

//          initializeService.tryLazyEagerLoading();
        	
//        	initializeWithInheritanceService.initInheritanceBuilding();
//        	initializeWithInheritanceService.findBuildingInCity();
//          initializeWithInheritanceService.initEmbeddableBuilding();
//        	initializeWithInheritanceService.initEnumeratedBuilding();
          
//        	initializeService.tryEntiylistener1();
//        	initializeService.tryEntiylistener2();
//        	initializeService.tryEntiylistener3();
        	
        };
    }
    
}
