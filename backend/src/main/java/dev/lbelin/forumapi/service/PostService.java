package dev.lbelin.forumapi.service;

import java.util.List;

import dev.lbelin.forumapi.model.Post;

public interface PostService {

    public List<Post> getAllPostsByThreadId(Long threadId);

    public List<Post> getAllPostsByAuthorId(Long authorId);

    public void deletePostById(Long id);

}
