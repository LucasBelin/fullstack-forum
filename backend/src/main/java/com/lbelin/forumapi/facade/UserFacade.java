package com.lbelin.forumapi.facade;

import java.util.List;

import com.lbelin.forumapi.dto.UserDetailsDto;

public interface UserFacade {

    public List<UserDetailsDto> getUsers();

}
