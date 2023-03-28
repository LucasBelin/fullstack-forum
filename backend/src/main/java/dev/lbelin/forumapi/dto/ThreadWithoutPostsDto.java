package dev.lbelin.forumapi.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ThreadWithoutPostsDto extends BaseDto {

    @NotBlank
    @Length(max = 255)
    private String title;

    @Length(max = 65535)
    private String description;

    private UserDto author;
}
