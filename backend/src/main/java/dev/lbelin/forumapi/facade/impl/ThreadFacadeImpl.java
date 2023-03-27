package dev.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.ThreadDto;
import dev.lbelin.forumapi.facade.ThreadFacade;
import dev.lbelin.forumapi.mapper.ThreadMapper;
import dev.lbelin.forumapi.model.Thread;
import dev.lbelin.forumapi.service.ThreadService;

@Service
public class ThreadFacadeImpl implements ThreadFacade {

    @Autowired
    private ThreadMapper threadMapper;

    @Autowired
    private ThreadService threadService;

    @Override
    public List<ThreadDto> getAllThreads() {
        return threadMapper.toDto(threadService.getAllThreads());
    }

    @Override
    public ThreadDto getThreadById(Long id) {
        return threadMapper.toDto(threadService.getThreadById(id));
    }

    @Override
    public List<ThreadDto> getAllThreadsByAuthorId(Long authorId) {
        return threadMapper.toDto(threadService.getAllThreadsByAuthorId(authorId));
    }

    @Override
    public ThreadDto createThread(Long authorId, ThreadDto threadDto) {
        Thread thread = threadMapper.toEntity(threadDto);
        return threadMapper.toDto(threadService.createThread(authorId, thread));
    }

    @Override
    public void deleteThreadById(Long id) {
        threadService.deleteThreadById(id);
    }
}
