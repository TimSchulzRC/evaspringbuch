package de.evaspringbuch.eva04p4howtodi.test;


import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import de.evaspringbuch.eva04p4howtodi.service.SecondShowService;
import de.evaspringbuch.eva04p4howtodi.service.ShowService;

@SpringBootTest //(classes = Eva04p4HowtoDI.class)
public class ServiceTest {

    @Test
    public void testMockDependencies() {
    	SecondShowService secondShow = mock(SecondShowService.class);
    	ShowService show = new ShowService();
//    	ShowService show = new ShowService(secondShow);
//    	show.setSecondShowService(secondShow);
    	show.doSomething();
    }

}
