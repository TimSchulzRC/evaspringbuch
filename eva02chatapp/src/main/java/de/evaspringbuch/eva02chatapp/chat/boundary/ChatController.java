package de.evaspringbuch.eva02chatapp.chat.boundary;

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

import de.evaspringbuch.eva02chatapp.chat.domain.Chat;
import de.evaspringbuch.eva02chatapp.chat.domain.ChatUser;
import de.evaspringbuch.eva02chatapp.chat.service.ChatUserService;

@Controller
public class ChatController {

    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

//    @Autowired
//    private ChatService chatService;

    @Autowired
    private ChatUserService chatUserService;

    @RequestMapping("/start")
    public String listingAllChats(@RequestParam String from, Model model) {
        ChatUser userFrom = chatUserService.getByNickname(from);
        List<Chat> targetList = new ArrayList<>(userFrom.getChats().values());
        model.addAttribute("fromUser", from);
        model.addAttribute("listAllChats", targetList);
        return "chat";
    }

    @RequestMapping(value = "/deleteChat", method = RequestMethod.POST)
    public String removeChat(@RequestParam String from, @RequestParam String to, Model model) {
        model.addAttribute("fromUser", from);
        chatUserService.deleteChatFromTo(from, to);
        return "redirect:start?from=" + from;
    }

}
