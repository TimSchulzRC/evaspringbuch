package de.evaspringbuch.eva08corsback.security.boundary;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.evaspringbuch.eva08corsback.security.domain.User;
import de.evaspringbuch.eva08corsback.security.service.user.UserService;

//@CrossOrigin
//@RestController 
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        LOGGER.info("Getting users page");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/users/{id}", method = {RequestMethod.POST,RequestMethod.GET})
    public User getUserPage(@PathVariable Long id, Model model) {
        LOGGER.debug("Getting user page for user= " + id);
        User user = userService.getUserById(id);
        if (user != null) model.addAttribute("user", user);
        else model.addAttribute("user", new NoSuchElementException(String.format("User=%s not found", id)));
        return user;
    }


}
