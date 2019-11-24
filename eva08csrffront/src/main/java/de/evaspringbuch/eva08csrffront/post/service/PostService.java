package de.evaspringbuch.eva08csrffront.post.service;

import java.util.List;

import de.evaspringbuch.eva08csrffront.post.domain.Post;
import de.evaspringbuch.eva08csrffront.post.service.dto.PostDTO;

public interface PostService {
    List<PostDTO> listAllPostsFromTo(String from, String to);

    void addPost(String from, String to, String pcontent);
}
