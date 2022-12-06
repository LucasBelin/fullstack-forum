package dev.lbelin.forumapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.lbelin.forumapi.dto.RegistrationDto;
import dev.lbelin.forumapi.dto.UserDto;
import dev.lbelin.forumapi.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

    User toEntity(RegistrationDto registrationDto);

    List<UserDto> toDto(List<User> users);
}
