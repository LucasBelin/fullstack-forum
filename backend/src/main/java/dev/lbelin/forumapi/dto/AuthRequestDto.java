package dev.lbelin.forumapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AuthRequestDto {
    
    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
