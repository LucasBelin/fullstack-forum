package dev.lbelin.forumapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.lbelin.forumapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByEmail(String email);
}
