package dev.lbelin.forumapi.facade;

import java.util.List;

import dev.lbelin.forumapi.dto.PostDto;

public interface PostFacade {

    public List<PostDto> getAllPostsByThreadId(Long threadId);

    public List<PostDto> getAllPostsByAuthorId(Long authorId);

    public void deletePostById(Long id);
}
