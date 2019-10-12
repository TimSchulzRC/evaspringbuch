package de.evaspringbuch.eva03chatapp.post.boundary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.evaspringbuch.eva03chatapp.post.domain.Post;
import de.evaspringbuch.eva03chatapp.post.service.PostService;

import java.util.List;

@Controller
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired private PostService postService;

    @RequestMapping("/posts")
    public String listAllPosts(@RequestParam String from, @RequestParam String to, Model model) {
        List<Post> list = postService.listAllPostsFromTo(from, to);
        model.addAttribute("listAllPosts", list);
        model.addAttribute("toUser", to);
        model.addAttribute("fromUser", from);
        model.addAttribute("currentUser", from);
        return "posting";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@RequestParam String from, @RequestParam String to, @RequestParam String pcontent, Model model) {
        model.addAttribute("fromUser", from);
        model.addAttribute("currentUser", from);
        List<Post> list = postService.listAllPostsFromTo(from, to);
        model.addAttribute("listAllPosts", list);
        postService.addPost(from, to, pcontent);
        return "redirect:posts?from="+ from + "&to=" + to;
    }

}
