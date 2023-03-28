package dev.lbelin.forumapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.exception.ExceptionMessageConstants;
import dev.lbelin.forumapi.exception.NotFoundException;
import dev.lbelin.forumapi.model.Post;
import dev.lbelin.forumapi.model.Thread;
import dev.lbelin.forumapi.model.User;
import dev.lbelin.forumapi.repository.PostRepository;
import dev.lbelin.forumapi.repository.ThreadRepository;
import dev.lbelin.forumapi.repository.UserRepository;
import dev.lbelin.forumapi.service.PostService;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllPostsByThreadId(Long threadId) {
        Optional<Thread> thread = threadRepository.findById(threadId);
        if (!thread.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.THREAD_ID_NOT_FOUND);
        }
        return postRepository.getAllPostsByThreadId(threadId);
    }

    @Override
    public List<Post> getAllPostsByAuthorId(Long authorId) {
        Optional<User> user = userRepository.findById(authorId);
        if (!user.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.USER_ID_NOT_FOUND);
        }
        return postRepository.getAllPostsByAuthorId(authorId);
    }

    @Override
    public Post createPost(Long authorId, Long threadId, Post post) {
        Optional<User> user = userRepository.findById(authorId);
        Optional<Thread> thread = threadRepository.findById(threadId);
        if (!user.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.USER_ID_NOT_FOUND);
        }
        if (!thread.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.THREAD_ID_NOT_FOUND);
        }
        Thread updatedThread = thread.get();
        updatedThread.update();
        post.setAuthor(user.get());
        post.setThread(updatedThread);
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long postId, Long threadId, Post post) {
        Optional<Thread> thread = threadRepository.findById(threadId);
        Optional<Post> postToUpdate = postRepository.findById(postId);
        if (!thread.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.THREAD_ID_NOT_FOUND);
        }
        if (!postToUpdate.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.POST_ID_NOT_FOUND);
        }
        postToUpdate.get().setContent(post.getContent());
        postToUpdate.get().update();
        thread.get().update();
        return postRepository.save(postToUpdate.get());
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (!post.isPresent()) {
            throw new NotFoundException(ExceptionMessageConstants.POST_ID_NOT_FOUND);
        }
        postRepository.deleteById(id);
    }

}
