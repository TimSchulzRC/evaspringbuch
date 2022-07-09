package de.evaspringbuch.eva07chatapp.post.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva07chatapp.post.service.PostService;
import de.evaspringbuch.eva07chatapp.post.service.dto.PostDTO;
import de.evaspringbuch.eva07chatapp.security.domain.CurrentUser;

@Controller
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    private PostService postService;
    private CurrentUser currentUser;

    @Autowired
    public PostController(PostService postService, CurrentUser currentUser) {
        this.postService = postService;
        this.currentUser = currentUser;
    }

    @RequestMapping("/posts")
    public String listAllPosts(@RequestParam String to, Model model) {
    	String from = getCurrentUser(model);
        List<PostDTO> list = postService.listAllPostsFromTo(from, to);
        model.addAttribute("listAllPosts", list);
        model.addAttribute("toUser", to);
        return "posting";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@RequestParam String to, @RequestParam String pcontent, Model model) {
    	String from = getCurrentUser(model);
        postService.addPost(from, to, pcontent);
        return "redirect:posts?to=" + to;
    }
    
    private String getCurrentUser(Model model) {
        String from = currentUser.getUser().getNickname();
        model.addAttribute("fromUser", from);
        return from;
    }

}
