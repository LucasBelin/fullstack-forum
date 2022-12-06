package dev.lbelin.forumapi.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDto {

    @NotNull
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private LocalDateTime createdOn;

    @NotBlank
    private LocalDateTime updatedOn;
}
