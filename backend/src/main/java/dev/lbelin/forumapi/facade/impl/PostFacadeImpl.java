package dev.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.PostDto;
import dev.lbelin.forumapi.dto.PostWithoutAuthorDto;
import dev.lbelin.forumapi.dto.PostWithoutThreadDto;
import dev.lbelin.forumapi.facade.PostFacade;
import dev.lbelin.forumapi.mapper.PostMapper;
import dev.lbelin.forumapi.service.PostService;

@Service
public class PostFacadeImpl implements PostFacade {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostService postService;

    @Override
    public List<PostDto> getAllPosts() {
        return postMapper.toDto(postService.getAllPosts());
    }

    @Override
    public List<PostWithoutThreadDto> getAllPostsByThreadId(Long threadId) {
        return postMapper.toDtoWithoutThread(postService.getAllPostsByThreadId(threadId));
    }

    @Override
    public List<PostWithoutAuthorDto> getAllPostsByAuthorId(Long authorId) {
        return postMapper.toDtoWithoutAuthor(postService.getAllPostsByAuthorId(authorId));
    }

    @Override
    public PostDto createPost(Long authorId, Long threadId, PostDto post) {
        return postMapper.toDto(postService.createPost(authorId, threadId, postMapper.toEntity(post)));
    }

    @Override
    public PostDto updatePost(Long postId, Long threadId, PostDto post) {
        return postMapper.toDto(postService.updatePost(postId, threadId, postMapper.toEntity(post)));
    }

    @Override
    public void deletePostById(Long id) {
        postService.deletePostById(id);
    }
}
