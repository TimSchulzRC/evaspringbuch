package de.evaspringbuch.eva09aop.tryAopProxy;

import javax.transaction.Transactional;

//@Service
//@Qualifier("zwei")
public class MyService2 implements MyServiceBase {

    @Transactional
    public void doSomething() {
        System.out.println("   > MyService2 < ");
    }
}
