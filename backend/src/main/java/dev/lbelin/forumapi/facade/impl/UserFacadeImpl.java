package dev.lbelin.forumapi.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.RegistrationDto;
import dev.lbelin.forumapi.dto.UserDto;
import dev.lbelin.forumapi.facade.UserFacade;
import dev.lbelin.forumapi.mapper.UserMapper;
import dev.lbelin.forumapi.service.UserService;

@Service
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<UserDto> getUsers() {
        return userMapper.toDto(userService.getUsers());
    }

    @Override
    public UserDto getUserByUsername(String username) {
        return userMapper.toDto(userService.getUserByUsername(username));
    }

    @Override
    public UserDto createUser(RegistrationDto userDto) {
        return userMapper.toDto(userService.createUser(userMapper.toEntity(userDto)));
    }
}
