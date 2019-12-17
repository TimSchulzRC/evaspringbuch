package de.evaspringbuch.eva12chatappevent.chat.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva12chatappevent.chat.service.ChatUserService;
import de.evaspringbuch.eva12chatappevent.chat.service.dto.ChatDTO;
import de.evaspringbuch.eva12chatappevent.common.CurrentUserUtil;

@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    private ChatUserService chatUserService;

    @Autowired 
    public ChatController(ChatUserService chatUserService) {
        this.chatUserService = chatUserService;
    }

    @RequestMapping("/first")
    public String firstPage(Model model) {
        String from = CurrentUserUtil.getCurrentUser(model);
        List<ChatDTO> targetList = chatUserService.getAllChatFrom(from);
        model.addAttribute("fromUser", from);
        model.addAttribute("listAllChats", targetList);
        return "chat";
    }

    @RequestMapping(value = "/newchat", method = {RequestMethod.POST, RequestMethod.GET})
    public String newChatPage(@RequestParam("nid") String to, Model model) {
        String from = CurrentUserUtil.getCurrentUser(model);
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
        String from = CurrentUserUtil.getCurrentUser(model);
        chatUserService.deleteChatFromTo(from, to);
        return "redirect:first";
    }

}
