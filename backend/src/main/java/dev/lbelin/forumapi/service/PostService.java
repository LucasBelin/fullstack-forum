package dev.lbelin.forumapi.service;

import java.util.List;

import dev.lbelin.forumapi.model.Post;

public interface PostService {

    public List<Post> getAllPosts();

    public List<Post> getAllPostsByThreadId(Long threadId);

    public List<Post> getAllPostsByAuthorId(Long authorId);

    public Post createPost(Long authorId, Long threadId, Post post);

    public Post updatePost(Long postId, Long threadId, Post post);

    public void deletePostById(Long id);
}
