package dev.lbelin.forumapi.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.lbelin.forumapi.dto.UserDetailsDto;
import dev.lbelin.forumapi.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserDetailsDto toDto(Optional<User> user);

    List<UserDetailsDto> toDto(List<User> users);
}
