package de.evaspringbuch.eva10transaction.tryTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class IsolationService {

    private static final Logger log = LoggerFactory.getLogger(IsolationService.class);
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Transactional 
    public void transfer(int amount, int accountSource) { 
    	   Account source = accountRepository.findById(accountSource).get();
    	   log.info(" account balance after read :: " + source.getBalance());
           try {
        	   Thread.sleep(5000);
           } catch (InterruptedException e) {
        	   e.printStackTrace();
           }
           source.withdraw(amount);
           accountRepository.save(source);
     	   log.info(" account balance after save :: " + source.getBalance() + " :: " + Thread.currentThread());
    }

}

 
