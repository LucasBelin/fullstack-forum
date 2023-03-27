package dev.lbelin.forumapi.facade;

import java.util.List;

import dev.lbelin.forumapi.dto.ThreadDto;

public interface ThreadFacade {

    public List<ThreadDto> getAllThreads();

    public List<ThreadDto> getAllThreadsByAuthorId(Long authorId);

    public ThreadDto createThread(Long authorId, ThreadDto threadDto);

    public void deleteThreadById(Long id);
}
