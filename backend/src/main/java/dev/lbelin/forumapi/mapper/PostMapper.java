package dev.lbelin.forumapi.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import dev.lbelin.forumapi.dto.PostDto;
import dev.lbelin.forumapi.model.Post;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostDto toDto(Post post);

    Post toEntity(PostDto postDto);

    List<PostDto> toDto(List<Post> posts);

    List<Post> toEntity(List<PostDto> postDtos);
}
