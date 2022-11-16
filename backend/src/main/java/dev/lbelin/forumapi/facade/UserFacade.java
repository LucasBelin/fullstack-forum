package dev.lbelin.forumapi.facade;

import java.util.List;

import dev.lbelin.forumapi.dto.UserDetailsDto;

public interface UserFacade {

    public List<UserDetailsDto> getUsers();

    public UserDetailsDto getUserByUsername(String username);
}
