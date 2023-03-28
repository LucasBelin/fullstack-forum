package dev.lbelin.forumapi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostDto extends BaseDto {

    @NotBlank
    @Length(max = 65535)
    private String content;

    private UserDto author;

    @NotNull
    private ThreadWithoutPostsDto thread;
}
