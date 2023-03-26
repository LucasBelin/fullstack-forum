package dev.lbelin.forumapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lbelin.forumapi.model.Thread;

public interface ThreadRepository extends JpaRepository<Thread, Long> {

    List<Thread> getAllThreadsByAuthorId(Long authorId);

    void deleteThreadById(Long id);
}
