package de.evaspringbuch.eva09aop.tryAopProxy;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

    @AfterReturning("execution(* de.evaspringbuch.eva09aop.tryAopProxy.MyService.doSomething(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }

}