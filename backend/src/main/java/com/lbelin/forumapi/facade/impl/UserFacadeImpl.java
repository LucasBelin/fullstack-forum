package com.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lbelin.forumapi.dto.UserDetailsDto;
import com.lbelin.forumapi.facade.UserFacade;
import com.lbelin.forumapi.mapper.UserMapper;
import com.lbelin.forumapi.service.UserService;

@Service
public class UserFacadeImpl implements UserFacade {
    
    private UserMapper userMapper;

    private UserService userService;

    public UserFacadeImpl(final UserMapper userMapper, final UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @Override
    public List<UserDetailsDto> getUsers() {
        return userMapper.toDto(userService.getUsers());
    }
}
