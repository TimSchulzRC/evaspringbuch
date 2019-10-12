package de.evaspringbuch.eva04p2howtodi.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmallService {
	
  private static final Logger log = LoggerFactory.getLogger(SmallService.class);

    String myPersonalName = "frieda";

    @PostConstruct
    public void doBeforeInitializing() {
    	log.info("doBeforeInitializing before upadating ... what's my personal name? " + myPersonalName);
        myPersonalName = "marga";
        log.info("doBeforeInitializing ... what's my personal name? " + myPersonalName);
    }

    public void doSomething() {
    	log.info("doSomething ... what's my personal name? " + myPersonalName);
    }

    @PreDestroy
    public void doBeforeDestroying() {
        myPersonalName = "elisa";
        log.info("doBeforeDestroying ... what's my personal name? " + myPersonalName);
    }


}