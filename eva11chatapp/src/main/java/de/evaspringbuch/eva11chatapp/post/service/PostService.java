package de.evaspringbuch.eva11chatapp.post.service;

import java.util.List;

import de.evaspringbuch.eva11chatapp.post.domain.Post;
import de.evaspringbuch.eva11chatapp.post.service.dto.PostDTO;

public interface PostService {
    List<PostDTO> listAllPostsFromTo(String from, String to);

    void addPost(String from, String to, String pcontent);
}
