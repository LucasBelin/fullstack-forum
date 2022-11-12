package com.lbelin.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbelin.forumapi.dto.UserDetailsDto;
import com.lbelin.forumapi.facade.UserFacade;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserFacade userFacade;

    @GetMapping
    public List<UserDetailsDto> getUsers() {
        return userFacade.getUsers();
    }
}
