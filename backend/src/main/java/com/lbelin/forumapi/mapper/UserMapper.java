package com.lbelin.forumapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.lbelin.forumapi.dto.UserDetailsDto;
import com.lbelin.forumapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDetailsDto toDto(User user);

    List<UserDetailsDto> toDto(List<User> users);
}
