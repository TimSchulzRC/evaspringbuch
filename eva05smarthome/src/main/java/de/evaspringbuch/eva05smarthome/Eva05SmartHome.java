package de.evaspringbuch.eva05smarthome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva05smarthome.complete.service.InitializeService;

@SpringBootApplication
public class Eva05SmartHome {

//    private static final Logger log = LoggerFactory.getLogger(Eva05SmartHome.class);

    @Autowired
    InitializeService initializeService;

    public static void main(String[] args) {
        SpringApplication.run(Eva05SmartHome.class);
    }

    @Bean
    CommandLineRunner init() {
        return (evt) -> {
//          start here   
        	initializeService.initBuildingAndAddressOne2OneBi();
//            initializeService.initPersonInHouseAndPersonOne2OneUni();

//            initializeService.initPersonInHouseAndRoomMany2OneBi();
//            initializeService.deletePersonInHouseAndRoomMany2OneBiV0();  

//            initializeService.initPersonInHouseAndRoomMany2OneBi();  
//            initializeService.deletePersonInHouseMany2OneBiV1();  

//            initializeService.initPersonInHouseAndBuildingMany2OneUni();   
//            initializeService.initBuildingAndRoomOne2ManyUni();
//            initializeService.initBuildingAndPersonMany2ManyBi();  

//	complete data model
//            initializeService.initMichael();   
//            initializeService.initKarl();   
//            initializeService.deletePersonInHouseMany2OneBi();   
        };
    }
}
