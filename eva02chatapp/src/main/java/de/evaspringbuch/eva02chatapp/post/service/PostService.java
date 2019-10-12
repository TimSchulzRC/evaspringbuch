package de.evaspringbuch.eva02chatapp.post.service;

import java.util.List;

import de.evaspringbuch.eva02chatapp.post.domain.Post;

/**
 * Created by wo on 19.09.2017.
 */

public interface PostService {
    List<Post> listAllPostsFromTo(String from, String to);

    void addPost(String from, String to, String pcontent);
}
