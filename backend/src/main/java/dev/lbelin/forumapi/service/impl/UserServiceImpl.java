package dev.lbelin.forumapi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.exception.ConflictException;
import dev.lbelin.forumapi.exception.ExceptionMessageConstants;
import dev.lbelin.forumapi.exception.NotFoundException;
import dev.lbelin.forumapi.model.User;
import dev.lbelin.forumapi.repository.UserRepository;
import dev.lbelin.forumapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new NotFoundException(ExceptionMessageConstants.USER_USERNAME_NOT_FOUND);
    }

    @Override
    public User createUser(User user) {
        Boolean userExists = userRepository.findByUsername(user.getUsername()).isPresent();
        if (userExists) {
            throw new ConflictException(ExceptionMessageConstants.USER_USERNAME_ALREADY_EXISTS);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
