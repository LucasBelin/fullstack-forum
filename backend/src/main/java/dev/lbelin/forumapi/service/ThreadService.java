package dev.lbelin.forumapi.service;

import java.util.List;

import dev.lbelin.forumapi.model.Thread;

public interface ThreadService {

    public List<Thread> getAllThreads();

    public Thread getThreadById(Long id);

    public List<Thread> getAllThreadsByAuthorId(Long authorId);

    public Thread createThread(Long authorId, Thread thread);

    public void deleteThreadById(Long id);
}
