package dev.lbelin.forumapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.lbelin.forumapi.dto.ThreadDto;
import dev.lbelin.forumapi.dto.ThreadWithoutPostsDto;
import dev.lbelin.forumapi.model.Thread;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ThreadMapper {

    ThreadDto toDto(Thread thread);

    ThreadWithoutPostsDto toDtoWithoutPosts(Thread thread);

    Thread toEntity(ThreadDto threadDto);

    Thread toEntity(ThreadWithoutPostsDto threadDto);

    List<ThreadDto> toDto(List<Thread> threads);

    List<Thread> toEntity(List<ThreadDto> threadDtos);
}
