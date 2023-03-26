package dev.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.PostDto;
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
    public List<PostDto> getAllPostsByThreadId(Long threadId) {
        return postMapper.toDto(postService.getAllPostsByThreadId(threadId));
    }

    @Override
    public List<PostDto> getAllPostsByAuthorId(Long authorId) {
        return postMapper.toDto(postService.getAllPostsByAuthorId(authorId));
    }

    @Override
    public void deletePostById(Long id) {
        postService.deletePostById(id);
    }
}
