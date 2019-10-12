package de.evaspringbuch.eva04p5scopes.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import de.evaspringbuch.eva04p5scopes.session.SomeService;

@Controller
public class SomeController {

    private static final Logger log = LoggerFactory.getLogger(SomeController.class);

    @Autowired
    ApplicationContext applicationContext;

    public SomeController() {
    }

    @RequestMapping(value = "/hit")
    public String showPage() {
        SomeService p1 = (SomeService) applicationContext.getBean(SomeService.class);
        SomeService p2 = (SomeService) applicationContext.getBean(SomeService.class);
        log.info(p1.getName());
        log.info(p2.getName());
        return "page";
    }

    @RequestMapping(value = "/hit2")
    public String showPage2() {
        SomeService p1 = (SomeService) applicationContext.getBean(SomeService.class);
        SomeService p2 = (SomeService) applicationContext.getBean(SomeService.class);
        log.info(p1.getName());
        log.info(p2.getName());
        return "page";
    }

}
