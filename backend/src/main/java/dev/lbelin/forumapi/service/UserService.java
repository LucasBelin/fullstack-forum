package dev.lbelin.forumapi.service;

import java.util.List;
import java.util.Optional;

import dev.lbelin.forumapi.model.User;

public interface UserService {

    List<User> getUsers();

    Optional<User> getUserByUsername(String username);
}
