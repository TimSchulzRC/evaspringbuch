package de.evaspringbuch.eva10transaction.tryTransaction;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionStatus;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
@Aspect
public class TransactionUtils {
	
	private static final Logger log = LoggerFactory.getLogger(TransactionUtils.class);

	@Pointcut("execution(* TransferService.*(..)) || execution(* OutTransferService.*(..)) ")
    public void transactionShow() {
    }

    @Before("transactionShow()")
    public void showTransactionStatus(JoinPoint joinPoint) {
    	String message = joinPoint.getTarget().getClass().getSimpleName().toString();
        log.info(((TransactionSynchronizationManager.isActualTransactionActive()) ? "   [+] " : "   [-] ") + message + " // in real " + 
    	           TransactionSynchronizationManager.getCurrentTransactionName());
        try {
        	TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        	log.info("       Method called ? " + joinPoint.getSignature().getName());
        	log.info("       Transaction status ? " + status);
        	log.info("       Transaction as rollback marked ? " + status.isRollbackOnly());
    		log.info("       Transaction isNewTransaction ? " + status.isNewTransaction());    
    	} catch (NoTransactionException e) {
    		log.info("       no transaction available !!! ");        	
		}
    }
    
//    public static void showTransactionStatus(String message) {
//        log.info(((TransactionSynchronizationManager.isActualTransactionActive()) ? "   [+] " : "   [-] ") + message + " // in real " + TransactionSynchronizationManager.getCurrentTransactionName());
//    }

}
