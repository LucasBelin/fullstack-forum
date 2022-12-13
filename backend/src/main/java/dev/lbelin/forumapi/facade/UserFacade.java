package dev.lbelin.forumapi.facade;

import java.util.List;

import dev.lbelin.forumapi.dto.RegistrationDto;
import dev.lbelin.forumapi.dto.UserDto;

public interface UserFacade {

    public List<UserDto> getUsers();

    public UserDto getUserByUsername(final String username);

    public UserDto createUser(final RegistrationDto userDto);
}
