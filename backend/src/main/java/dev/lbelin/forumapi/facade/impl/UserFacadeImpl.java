package dev.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.UserDetailsDto;
import dev.lbelin.forumapi.facade.UserFacade;
import dev.lbelin.forumapi.mapper.UserMapper;
import dev.lbelin.forumapi.service.UserService;

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

    @Override
    public UserDetailsDto getUserByUsername(String username) {
        return userMapper.toDto(userService.getUserByUsername(username));
    }
}
