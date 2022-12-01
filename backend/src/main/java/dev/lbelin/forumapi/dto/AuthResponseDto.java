package dev.lbelin.forumapi.dto;

import lombok.Data;

@Data
public class AuthResponseDto {

    private String token;
    private String tokenType = "Bearer";
    private Long expiresIn;

    public AuthResponseDto(final String token, final Long expiresIn) {
        this.token = token;
        this.expiresIn = expiresIn;
    }
}
