package de.evaspringbuch.eva09aop.tryAopProxy;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Qualifier("eins")
public class MyService implements MyServiceBase {

    @Autowired
    private SomeEntityRepository someEntityRepository;

    @Transactional
    public void doSomething() {

        someEntityRepository.save(new SomeEntity());
        System.out.println("   > MyService < ");
    }
}
