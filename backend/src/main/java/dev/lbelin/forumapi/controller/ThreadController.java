package dev.lbelin.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<ThreadDto> getAllThreadsByAuthorId(@PathVariable Long authorId) {
        return threadFacade.getAllThreadsByAuthorId(authorId);
    }

    @PostMapping
    public ThreadDto createThread(@RequestParam Long authorId, @RequestBody ThreadDto threadDto) {
        return threadFacade.createThread(authorId, threadDto);
    }

    @DeleteMapping("/{id}")
    public void deleteThreadById(@PathVariable Long id) {
        threadFacade.deleteThreadById(id);
    }
}
