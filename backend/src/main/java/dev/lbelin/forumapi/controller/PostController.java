package dev.lbelin.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.lbelin.forumapi.dto.PostDto;
import dev.lbelin.forumapi.dto.PostWithoutAuthorDto;
import dev.lbelin.forumapi.dto.PostWithoutThreadDto;
import dev.lbelin.forumapi.facade.PostFacade;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostFacade postFacade;

    @GetMapping
    public List<PostDto> getAllPosts() {
        return postFacade.getAllPosts();
    }

    @GetMapping("/thread/{threadId}")
    public List<PostWithoutThreadDto> getAllPostsByThreadId(@PathVariable Long threadId) {
        return postFacade.getAllPostsByThreadId(threadId);
    }

    @GetMapping("/author/{authorId}")
    public List<PostWithoutAuthorDto> getAllPostsByAuthorId(@PathVariable Long authorId) {
        return postFacade.getAllPostsByAuthorId(authorId);
    }

    @PostMapping
    public PostDto createPost(@RequestParam Long authorId, @RequestParam Long threadId, @RequestBody PostDto post) {
        return postFacade.createPost(authorId, threadId, post);
    }

    @PutMapping
    public PostDto updatePost(@RequestParam Long postId, @RequestParam Long threadId,
            @RequestBody PostDto post) {
        return postFacade.updatePost(postId, threadId, post);
    }

    @DeleteMapping
    public void deletePostById(@PathVariable Long id) {
        postFacade.deletePostById(id);
    }
}
