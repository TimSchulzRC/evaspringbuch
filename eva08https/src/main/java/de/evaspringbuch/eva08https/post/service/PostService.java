package de.evaspringbuch.eva08https.post.service;

import java.util.List;

import de.evaspringbuch.eva08https.post.service.dto.PostDTO;

public interface PostService {
    List<PostDTO> listAllPostsFromTo(String from, String to);

    void addPost(String from, String to, String pcontent);
}
