package de.evaspringbuch.eva04p3completebeanlifecycle.service;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanPostProcessor implements BeanPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(CustomBeanPostProcessor.class);
	
        public CustomBeanPostProcessor() {
            log.info("the beginning - Spring calls the constructor");
        }

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName)
                throws BeansException { //+ bean.getClass()
            if (bean instanceof CompleteService) {
            	log.info("postProcessBeforeInitialization // "  + "  " + beanName);
                try {
                    Field f = bean.getClass().getDeclaredField("myPersonalName");
                    f.setAccessible(true);
                    String s = f.toGenericString();
                    s = "greta";
                    f.set(bean, s);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            return bean;
        }

        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName)
                throws BeansException { //+bean.getClass()
            if (bean instanceof CompleteService) {
            	log.info("postProcessAfterInitialization // "  + "  " + beanName);
            	((CompleteService) bean).setMyPersonalName("hilde");}
            return bean;
        }


}
