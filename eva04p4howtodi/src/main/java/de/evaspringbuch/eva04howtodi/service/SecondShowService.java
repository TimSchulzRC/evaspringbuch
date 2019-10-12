package de.evaspringbuch.eva04howtodi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SecondShowService {

	private static final Logger log = LoggerFactory.getLogger(SecondShowService.class);
	
    public void doIt() {
        log.info("just a moment, i am doing ... ");
    }
}
