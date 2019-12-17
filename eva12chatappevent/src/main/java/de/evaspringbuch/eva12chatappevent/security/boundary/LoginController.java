package de.evaspringbuch.eva12chatappevent.security.boundary;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva12chatappevent.security.domain.CurrentUser;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
    private HttpServletRequest request;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String getLoginPage(@RequestParam Optional<String> error, Model model) {
		log.debug("hallo bei evaChatApp");		
		return "login";
	}

}
