package com.lbelin.forumapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lbelin.forumapi.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> { }
