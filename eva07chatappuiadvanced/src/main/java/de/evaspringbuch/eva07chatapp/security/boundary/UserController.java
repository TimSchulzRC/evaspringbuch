package de.evaspringbuch.eva07chatapp.security.boundary;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.evaspringbuch.eva07chatapp.chat.service.ChatUserServiceImpl;
import de.evaspringbuch.eva07chatapp.security.domain.UserCreateForm;
import de.evaspringbuch.eva07chatapp.security.service.dto.UserDTO;
import de.evaspringbuch.eva07chatapp.security.service.user.UserService;
import de.evaspringbuch.eva07chatapp.security.service.validator.UserCreateFormValidator;

@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private UserService userService;
    private ChatUserServiceImpl chatUserService;
    private UserCreateFormValidator userCreateFormValidator;

    @Autowired
    public UserController(UserService userService, ChatUserServiceImpl chatUserService, UserCreateFormValidator userCreateFormValidator) {
        this.userService = userService;
        this.chatUserService = chatUserService;
        this.userCreateFormValidator = userCreateFormValidator;
    }

    @InitBinder("myform")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(userCreateFormValidator);
    }

    @RequestMapping("/users")
    public String getUsersPage(Model model) {
        log.info("Getting users page");
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/users/{id}", method = {RequestMethod.POST,RequestMethod.GET})
    public String getUserPage(@PathVariable Long id, Model model) {
        log.debug("Getting user page for user= " + id);
        UserDTO userDTO = userService.getUserById(id);
        model.addAttribute("user", userDTO);
        model.addAttribute("fromUser", userDTO.getNickname());
        return "user";
    }
    

    @RequestMapping(value = "/users/managed", method = {RequestMethod.POST,RequestMethod.GET}) 
    public String getUserManagedPage(Model model) {
        log.debug("Getting user create form");
        model.addAttribute("myform", new UserCreateForm());
        model.addAttribute("users", userService.getAllUsers());
        return "user_create";
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/users/create", method = RequestMethod.POST)
    public String handleUserCreateForm(@Valid @ModelAttribute("myform") UserCreateForm form, BindingResult bindingResult, Model model) {
        log.info("Processing user create form= " + form + " bindingResult= " + bindingResult);
        model.addAttribute("users", userService.getAllUsers());
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", bindingResult.getGlobalError().getDefaultMessage());
            return "user_create";
        }
            userService.create(form);
            chatUserService.createChatUser(form);
        return "redirect:/users/managed";
    }

}
