package de.evaspringbuch.eva10transaction.tryTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private static final Logger log = LoggerFactory.getLogger(TransferService.class);
    
    @Autowired
    private AccountRepository accountRepository;

    public void firstTransfer(int amount, int accountSource, int accountTarget) {
    	transfer(amount, accountSource, accountTarget);
    }
    
    @Transactional (propagation = Propagation.REQUIRES_NEW)//(rollbackFor = Exception.class) //(propagation = Propagation.REQUIRES_NEW)
    public void transfer(int amount, int accountSource, int accountTarget) { //throws Exception 
//   	 try {
    	   Account source = accountRepository.findById(accountSource).get();
           Account target = accountRepository.findById(accountTarget).get();

            source.withdraw(amount);
////            first
//            throw new RuntimeException();
            
////            second
            target.deposit(amount);
            accountRepository.save(source);
//            
//            throw new RuntimeException("in transfer seems to be a problem"); // 
//            throw new Exception();  
//            accountRepository.save(target);
//            throw new RuntimeException();

//            third
//        } catch (Exception e) {
//            TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
////            status.setRollbackOnly();
//            log.info("Transaction as rollback marked ? " + status.isRollbackOnly());
//        }
    }

}

 
