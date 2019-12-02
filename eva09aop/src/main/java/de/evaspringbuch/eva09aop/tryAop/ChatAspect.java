package de.evaspringbuch.eva09aop.tryAop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ChatAspect {

    private static final Logger log = LoggerFactory.getLogger(ChatAspect.class);

//  -----------------
    @Pointcut("execution(* ChatService.get*()) ")
    public void chatGet() {
    }

    //    @Before("execution(public String getChat())")
    @Before("chatGet()")
    public void getChatAdvice() {
        log.info("==>(getChatAdvice) Executing Advice on getChat() or getId()");
    }
    
//  -----------------
    @Pointcut("execution(* ChatService.set(..)) ")
    public void chatSet() {
    }
    
    @Before("chatSet()")
    public void setAllAdvice(JoinPoint joinPoint) {
        log.info("==>(setAllAdvice) Service method setter called");        
    }

//  -----------------
    @Pointcut("within(de.evaspringbuch.eva09aop.tryAop.*)")
    public void allMethodsPointcut() {
    }
 
    @Before("allMethodsPointcut()")
    public void pointcutForAll(JoinPoint joinPoint) {
        log.info(">>>(pointcutForAll) each methods are adviced");
        log.info(">>>(pointcutForAll) Before running loggingAdvice on method=" + joinPoint.toString());
        log.info(">>>(pointcutForAll)Arguments Passed=" + Arrays.toString(joinPoint.getArgs()));
    }

//  -----------------
    @Around("execution(* de.evaspringbuch.eva09aop.*.*.c*(..))") //de.evaspringbuch.eva09aop.tryAop
    public Object createChatAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("=====>(createChatAdvice) Start invoking on createChatAdvice*()");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        log.info("=====>(createChatAdvice) After invoking c*() method. Return value=" + value);
        return value;
    }

}
