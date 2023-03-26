package dev.lbelin.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lbelin.forumapi.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getAllPostsByThreadId(Long threadId);

    List<Post> getAllPostsByAuthorId(Long authorId);

    void deletePostById(Long id);
}
