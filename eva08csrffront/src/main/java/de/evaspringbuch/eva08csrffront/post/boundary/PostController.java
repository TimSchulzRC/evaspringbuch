package de.evaspringbuch.eva08csrffront.post.boundary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva08csrffront.common.CurrentUserUtil;
import de.evaspringbuch.eva08csrffront.post.service.PostService;
import de.evaspringbuch.eva08csrffront.post.service.dto.PostDTO;

@Controller
public class PostController {

	private static final Logger log = LoggerFactory.getLogger(PostController.class);

    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping("/posts")
    public String listAllPosts(@RequestParam String to, Model model) {
        String from = CurrentUserUtil.getCurrentUser(model);
        List<PostDTO> list = postService.listAllPostsFromTo(from, to);
        model.addAttribute("listAllPosts", list);
        model.addAttribute("toUser", to);
        return "posting";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
//    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@RequestParam String to, @RequestParam String pcontent, Model model) {
    	String from = CurrentUserUtil.getCurrentUser(model);
        postService.addPost(from, to, pcontent);
        return "redirect:posts?to=" + to;
    }
}
