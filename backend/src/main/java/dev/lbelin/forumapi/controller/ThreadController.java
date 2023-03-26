package dev.lbelin.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lbelin.forumapi.dto.ThreadDto;
import dev.lbelin.forumapi.facade.ThreadFacade;

@RestController
@RequestMapping("/api/threads")
public class ThreadController {

    @Autowired
    private ThreadFacade threadFacade;

    @GetMapping
    public List<ThreadDto> getAllThreads() {
        return threadFacade.getAllThreads();
    }

    @GetMapping("/{authorId}")
    public List<ThreadDto> getAllThreadsByAuthorId(Long authorId) {
        return threadFacade.getAllThreadsByAuthorId(authorId);
    }

    // @PostMapping
    // public ThreadDto createThread(ThreadDto threadDto) {
    // return threadFacade.createThread(threadDto);
    // }

    @DeleteMapping("/{id}")
    public void deleteThreadById(Long id) {
        threadFacade.deleteThreadById(id);
    }
}
