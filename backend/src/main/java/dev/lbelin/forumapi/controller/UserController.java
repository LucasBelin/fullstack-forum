package dev.lbelin.forumapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.lbelin.forumapi.dto.RegistrationDto;
import dev.lbelin.forumapi.dto.UserDto;
import dev.lbelin.forumapi.facade.UserFacade;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @GetMapping
    public List<UserDto> getUsers() {
        return userFacade.getUsers();
    }

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable final String username) {
        return userFacade.getUserByUsername(username);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto createUser(@RequestBody final RegistrationDto userDto) {
        return userFacade.createUser(userDto);
    }
}
