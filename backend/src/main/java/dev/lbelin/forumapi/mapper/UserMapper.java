package dev.lbelin.forumapi.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.lbelin.forumapi.dto.UserDto;
import dev.lbelin.forumapi.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toDto(Optional<User> user);

    List<UserDto> toDto(List<User> users);
}
