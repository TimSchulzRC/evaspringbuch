package de.evaspringbuch.eva09aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import de.evaspringbuch.eva09aop.tryAop.Chat;
import de.evaspringbuch.eva09aop.tryAop.ChatService;

@SpringBootApplication
public class Eva09Aop {

	private static final Logger log = LoggerFactory.getLogger(Eva09Aop.class);

////	first ......................
	@Autowired
	ChatService chatService;

//	second ......................	
//	 @Autowired
//	 // @Qualifier("zwei")
//	 MyServiceBase myServiceBase;
//
//	 @Autowired
//	 CglibService cglibService;
//	
//	 @Autowired
//	 ApplicationContext applicationContext;


	public static void main(String[] args) {
		SpringApplication.run(Eva09Aop.class);
	}

////	first
	@Bean
	CommandLineRunner initAop() {
		return (evt) -> {
			chatService.createChat("newChat");
			chatService.getChat();
			chatService.setChat(new Chat());
			chatService.getId();			
		};
	}

//	second		
//	 @Bean
//	 CommandLineRunner init() {
//	 return (evt) -> {
//	 // LOGGER.info(" --!!!-- " + myServiceBase.getClass().toString());
//	
//	 MyServiceBase myService = (MyServiceBase)
//	 applicationContext.getBean(MyService.class);
//	 log.info(" --- " + myService.getClass().toString());
//	
//	 String myServiceClassName = myService.getClass().getName();
//	 log.info(myServiceClassName);
//	 Object mySer = applicationContext.getBean(MyService.class);
//	 log.info(">> MyService :: " + mySer.getClass().getTypeName());
//	 log.info(">> --------- :: " + mySer.toString());
//	 log.info(">> --------- :: " + applicationContext.getBeanNamesForType(MyService.class)[0]);
//	
//	 // myServiceBase.doSomething();
//	
//	 Object myCglib = applicationContext.getBean(CglibService.class);
//	 log.info(">> CglibService :: " + myCglib.getClass().getTypeName());
//	
//	 Object myPrepo = applicationContext.getBean(SomeEntityRepository.class);
//	 log.info(">> SomeEntityRepository :: " + myPrepo.getClass().getTypeName());
//	
//	 };
//	 }

}
