package de.evaspringbuch.eva07chatapp.security.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import de.evaspringbuch.eva07chatapp.security.domain.CurrentUser;

@ControllerAdvice
public class CurrentUserControllerAdvice {

//    private static final Logger log = LoggerFactory.getLogger(CurrentUserControllerAdvice.class);

    @Autowired CurrentUser currentUser;

    @ModelAttribute("currentUser")
    public CurrentUser getCurrentUser() {
//        LOGGER.debug("  " + currentUser.getNickname() + " //");
        return currentUser;
    }

}
