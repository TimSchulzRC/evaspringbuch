package de.evaspringbuch.eva04p3completebeanlifecycle.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class CompleteService implements ApplicationContextAware,
        BeanFactoryAware,
        BeanNameAware,
        InitializingBean, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(CompleteService.class);
	
    String myPersonalName = "frieda";

    public void setMyPersonalName(String myPersonalName) {
        this.myPersonalName = myPersonalName;
    }

    @Override
    public void setBeanName(String arg0) {
    	log.info("setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
    	log.info("setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
    	log.info("setApplicationContext");
    }

    public void destroy() throws Exception {
    	log.info("now I am in destroy... ");
    }

    public void afterPropertiesSet() throws Exception {
    	log.info("now I am in afterPropertiesSet...");
    }

    @PostConstruct
    public void doBeforeInitializing() {
    	log.info("doBeforeInitializing...");
    }

    public void doSomething() {
    	log.info("doSomething ...");
    }

    @PreDestroy
    public void doBeforeDestroying() {
    	log.info("doBeforeDestroying...");
    }
}