package dev.lbelin.forumapi.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.business.UserBusiness;
import dev.lbelin.forumapi.exception.BadRequestException;
import dev.lbelin.forumapi.exception.ConflictException;
import dev.lbelin.forumapi.exception.ExceptionMessageConstants;
import dev.lbelin.forumapi.model.User;
import dev.lbelin.forumapi.repository.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean isPasswordValid(String password) {
        // minimum 8 characters, at least one uppercase letter, one lowercase letter,
        // one number and one special character (@#$%&+=!)
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&+=!])[A-Za-z\\d@$!%*?&]{8,}$");
    }

    @Override
    public void validateUserData(User user) {
        Boolean usernameExists = userRepository.existsByUsername(user.getUsername());
        if (usernameExists) {
            throw new ConflictException(ExceptionMessageConstants.USER_USERNAME_ALREADY_EXISTS);
        }
        Boolean emailExists = userRepository.existsByEmail(user.getEmail());
        if (emailExists) {
            throw new ConflictException(ExceptionMessageConstants.USER_EMAIL_ALREADY_EXISTS);
        }
        if (!isPasswordValid(user.getPassword())) {
            throw new BadRequestException(ExceptionMessageConstants.USER_PASSWORD_NOT_VALID);
        }
    }
}
