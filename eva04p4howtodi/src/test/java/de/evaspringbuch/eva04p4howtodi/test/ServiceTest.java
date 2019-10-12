package de.evaspringbuch.eva04p4howtodi.test;


import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.evaspringbuch.eva04howtodi.Eva04p4HowtoDI;
import de.evaspringbuch.eva04howtodi.service.SecondShowService;
import de.evaspringbuch.eva04howtodi.service.ShowService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Eva04p4HowtoDI.class)
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
