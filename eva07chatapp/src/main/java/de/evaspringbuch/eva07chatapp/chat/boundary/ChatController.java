package de.evaspringbuch.eva07chatapp.chat.boundary;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva07chatapp.chat.domain.Chat;
import de.evaspringbuch.eva07chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva07chatapp.chat.service.ChatUserService;
import de.evaspringbuch.eva07chatapp.chat.service.dto.ChatDTO;
import de.evaspringbuch.eva07chatapp.security.domain.CurrentUser;
import de.evaspringbuch.eva07chatapp.security.service.user.UserService;

@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private ChatUserService chatUserService;

    private UserService userService;

    private CurrentUser currentUser;

    @Autowired
    public ChatController(ChatUserService chatUserService, UserService userService, CurrentUser currentUser) {
        this.chatUserService = chatUserService;
        this.userService = userService;
        this.currentUser = currentUser;
    }
    

    @RequestMapping(value = "/first", method = {RequestMethod.POST, RequestMethod.GET})
    public String firstPage(@RequestParam String email, @RequestParam String password, Model model) {
        if (!userService.existsByEmail(email)) { //).existsByEmail
            model.addAttribute("error","falscher Login");
            return "login";
        }
        if (!password.equals(userService.getUserByEmail(email).get().getPassword())) {
            model.addAttribute("error","falscher Login");
            return "login";
        }
        currentUser.setUser(userService.getUserByEmail(email).get());
        String from = currentUser.getNickname();
        ChatUser userFrom = chatUserService.getByNickname(from);
        List<ChatDTO> targetList = chatUserService.getAllChatFrom(from);
        model.addAttribute("fromUser", from);
        model.addAttribute("listAllChats", targetList);
        return "chat";
    }
    
    @RequestMapping(value = "/start", method = {RequestMethod.POST, RequestMethod.GET})
    public String startPage(@RequestParam String fromUser, Model model) {
    	String from = getCurrentUser(model);
        ChatUser userFrom = chatUserService.getByNickname(from);
        List<ChatDTO> targetList = chatUserService.getAllChatFrom(from);
        model.addAttribute("listAllChats", targetList);
        return "chat";
    }
    
    @RequestMapping(value = "/newchat", method = {RequestMethod.POST, RequestMethod.GET})
    public String newChatPage(@RequestParam("nid") String to, Model model) {
    	String from = getCurrentUser(model);
        if (to.equals("")) {
            model.addAttribute("error","");
        } else
        if ((!chatUserService.existsNickname(to)) ) { //(to.equals("")) ||
            model.addAttribute("error","der teilnehmer ist unbekannt !!!");
        } else
            if (chatUserService.chatUserChatsContainsKeyfindByNickname(from, to) || (to == " ")) {
                model.addAttribute("error","du hast schon einen chat mit diesem teilnehmer");
            }
            else
                if (from.equals(to)) {
                    model.addAttribute("error","du darfst nicht mit dir selber chatten");
                }
                else {
                    chatUserService.newChatFromTo(from, to);
                }
        List<ChatDTO> targetList = chatUserService.getAllChatFrom(from);        
        model.addAttribute("listAllChats", targetList);
        return "newchat";
    }

    @RequestMapping(value = "/deleteChat", method = RequestMethod.POST)
    public String removeChat(@RequestParam String to, Model model) {
    	String from = getCurrentUser(model);
        chatUserService.deleteChatFromTo(from, to);
        return "redirect:start?fromUser=" + from;
    }
    
    private String getCurrentUser(Model model) {
        String from = currentUser.getUser().getNickname();
        model.addAttribute("fromUser", from);
        return from;
    }

}
