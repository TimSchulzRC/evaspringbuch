package de.evaspringbuch.eva11mobpay.usermobpay.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.evaspringbuch.eva11mobpay.usermobpay.domain.PayUser;
import de.evaspringbuch.eva11mobpay.usermobpay.domain.PayUserRepository;
import de.evaspringbuch.eva11mobpay.usermobpay.domain.State;

import javax.annotation.PostConstruct;

@Component
public class InitializeDB {

    private static final Logger log = LoggerFactory.getLogger(InitializeDB.class);

    @Autowired private PayUserRepository payUserRepository;

    @PostConstruct
    public void init()  {

            log.debug("Db initialized");

            PayUser payUser = new PayUser();
            payUser.setName("elisa");
            payUser.setState(State.available);
            payUserRepository.save(payUser);

            payUser = new PayUser();
            payUser.setName("marga");
            payUser.setState(State.available); //doesNotExist);
            payUserRepository.save(payUser);

            payUser = new PayUser();
            payUser.setName("frieda");
            payUser.setState(State.suspended); //requested
            payUserRepository.save(payUser);

            payUser = new PayUser();
            payUser.setName("agneta");
            payUser.setState(State.suspended);
            payUserRepository.save(payUser);

    }
}
