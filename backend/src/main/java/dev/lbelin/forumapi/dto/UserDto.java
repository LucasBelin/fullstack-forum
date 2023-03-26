package dev.lbelin.forumapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends BaseDto {

    @NotBlank
    private String username;

    @NotBlank
    private String email;
}
