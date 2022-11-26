package dev.lbelin.forumapi.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import dev.lbelin.forumapi.dto.UserDetailsDto;
import dev.lbelin.forumapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDetailsDto toDto(Optional<User> optional);

    List<UserDetailsDto> toDto(List<User> users);
}
