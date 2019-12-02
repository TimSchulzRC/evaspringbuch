package de.evaspringbuch.eva10transaction.tryTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IsolationController {

    private static final Logger log = LoggerFactory.getLogger(IsolationController.class);

    @Autowired
    private IsolationService isolationService;

    @RequestMapping("/start")
    public String startPage() {
    	isolationService.transfer(10, 1);        
    	return "redirect:index.html";
    }

}
