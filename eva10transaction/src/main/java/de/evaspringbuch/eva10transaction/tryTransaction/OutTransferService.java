package de.evaspringbuch.eva10transaction.tryTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class OutTransferService {

    @Autowired
    private TransferService transferService;
    
    private static final Logger log = LoggerFactory.getLogger(OutTransferService.class);

    @Transactional //(rollbackFor = Exception.class) // (propagation = Propagation.REQUIRES_NEW)
    public void outTransfer(int amount, int accountSource, int accountTarget) {
    	
    	 try {
            transferService.transfer(amount, accountSource, accountTarget);
//            transferService.firstTransfer(amount, accountSource, accountTarget);
           
            } catch (Exception e) {
                // handle exception
            log.info("   ExceptionHandling in OutTransferService :: " + e);
          TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
//          status.setRollbackOnly();
          log.info("Transaction as rollback marked ? " + status + " :: " + status.isRollbackOnly());
            }
        }
}

