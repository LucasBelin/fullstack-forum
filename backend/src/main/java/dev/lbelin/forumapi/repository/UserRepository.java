package dev.lbelin.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.lbelin.forumapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { 

    User findByUsername(String username);
}