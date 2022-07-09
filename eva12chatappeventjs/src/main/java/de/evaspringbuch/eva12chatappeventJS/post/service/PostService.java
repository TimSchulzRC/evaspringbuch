package de.evaspringbuch.eva12chatappeventJS.post.service;

import java.util.List;

import de.evaspringbuch.eva12chatappeventJS.post.service.dto.PostDTO;

public interface PostService {
    List<PostDTO> listAllPostsFromTo(String from, String to);

    void addPost(String from, String to, String pcontent);
}
