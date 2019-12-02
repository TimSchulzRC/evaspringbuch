package de.evaspringbuch.eva10transaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import de.evaspringbuch.eva10transaction.tryTransaction.Account;
import de.evaspringbuch.eva10transaction.tryTransaction.AccountRepository;
import de.evaspringbuch.eva10transaction.tryTransaction.IsolationService;
import de.evaspringbuch.eva10transaction.tryTransaction.OutTransferService;

@SpringBootApplication
public class Eva10Transaction {

	private static final Logger log = LoggerFactory.getLogger(Eva10Transaction.class);

	@Autowired
	OutTransferService outTransferService;

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(Eva10Transaction.class);
	}

	@Bean
	public CommandLineRunner tryTransaction() {
		return (evt) -> {
			Account acc1 = new Account();
			Account acc2 = new Account();
			accountRepository.save(acc1);
			accountRepository.save(acc2);
			try {
				outTransferService.outTransfer(100, 1, 2);	
			} catch (Exception e) {
				// TODO: handle exception
				log.debug("Caught "+ e);
			}
			log.debug("acc1 = " + accountRepository.findById(1).get().getBalance());
			log.debug("acc2 = " + accountRepository.findById(2).get().getBalance());
		};
	}
	
//	@Bean
//	public CommandLineRunner tryIsolation() {
//		return (evt) -> {
//			Account acc1 = new Account();
//			Account acc2 = new Account();
//			accountRepository.save(acc1);
//			accountRepository.save(acc2);
//		};
//	}
}
