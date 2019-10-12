package de.evaspringbuch.eva04p5scopes.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;


//@Scope(value = "prototype") //prototype, singleton, request
@Scope(value = "singleton") //prototype, singleton, request
//@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Service
public class SomeService {

    private static final Logger log = LoggerFactory.getLogger(SomeService.class);

    private String name;

    public SomeService() {
        name = UUID.randomUUID().toString();
        log.info(">>>> eine SomeService-Bean ist konstruiert worden und hoert auf den Namen " + name);
    }

    public String getName() {
        return name;
    }
}
