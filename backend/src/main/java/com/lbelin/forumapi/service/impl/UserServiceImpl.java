package com.lbelin.forumapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lbelin.forumapi.mapper.UserMapper;
import com.lbelin.forumapi.model.User;
import com.lbelin.forumapi.repository.UserRepository;
import com.lbelin.forumapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}

