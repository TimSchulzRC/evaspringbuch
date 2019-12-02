package de.evaspringbuch.eva09aop.tryAopProxy;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class CglibService {

    @Transactional
    public void doSomething() {
        System.out.println("   > CglibService < ");
    }
}
