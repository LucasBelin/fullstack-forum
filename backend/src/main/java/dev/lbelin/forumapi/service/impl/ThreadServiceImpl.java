package dev.lbelin.forumapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.exception.ExceptionMessageConstants;
import dev.lbelin.forumapi.exception.NotFoundException;
import dev.lbelin.forumapi.model.Thread;
import dev.lbelin.forumapi.model.User;
import dev.lbelin.forumapi.repository.ThreadRepository;
import dev.lbelin.forumapi.repository.UserRepository;
import dev.lbelin.forumapi.service.ThreadService;

@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Thread> getAllThreads() {
        return threadRepository.findAll();
    }

    @Override
    public List<Thread> getAllThreadsByAuthorId(Long authorId) {
        Optional<User> user = userRepository.findById(authorId);
        if (!user.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.USER_ID_NOT_FOUND);
        }
        return threadRepository.getAllThreadsByAuthorId(authorId);
    }

    @Override
    public Thread createThread(Thread thread) {
        Optional<User> user = userRepository.findById(thread.getAuthor().getId());
        if (!user.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.USER_ID_NOT_FOUND);
        }
        return threadRepository.save(thread);
    }

    @Override
    public void deleteThreadById(Long id) {
        Optional<Thread> thread = threadRepository.findById(id);
        if (!thread.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.THREAD_ID_NOT_FOUND);
        }
        threadRepository.deleteById(id);
    }

}
