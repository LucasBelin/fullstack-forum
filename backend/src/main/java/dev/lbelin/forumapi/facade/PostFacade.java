package dev.lbelin.forumapi.facade;

import java.util.List;

import dev.lbelin.forumapi.dto.PostDto;
import dev.lbelin.forumapi.dto.PostWithoutAuthorDto;
import dev.lbelin.forumapi.dto.PostWithoutThreadDto;

public interface PostFacade {

    public List<PostDto> getAllPosts();

    public List<PostWithoutThreadDto> getAllPostsByThreadId(Long threadId);

    public List<PostWithoutAuthorDto> getAllPostsByAuthorId(Long authorId);

    public PostDto createPost(Long authorId, Long threadId, PostDto post);

    public PostDto updatePost(Long postId, Long threadId, PostDto post);

    public void deletePostById(Long id);
}
