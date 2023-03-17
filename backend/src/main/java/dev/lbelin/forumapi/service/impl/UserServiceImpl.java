package dev.lbelin.forumapi.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.business.impl.UserBusinessImpl;
import dev.lbelin.forumapi.exception.BadRequestException;
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

    @Autowired
    private UserBusinessImpl userBusiness;

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

    /**
     * @throws ConflictException            if a user with the same username or
     *                                      email already exists (http 409)
     * @throws BadRequestException          if the password is not valid (http 400)
     * @throws ConstraintViolationException if the email is not valid or if one of
     *                                      the required field is empty (http 500)
     */
    @Override
    public User createUser(User user) {
        userBusiness.validateUserData(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
