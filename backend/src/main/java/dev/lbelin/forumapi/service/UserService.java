package dev.lbelin.forumapi.service;

import java.util.List;

import dev.lbelin.forumapi.model.User;

public interface UserService {

    List<User> getUsers();

    User getUserByUsername(String username);
}
