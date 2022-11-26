package dev.lbelin.forumapi.service;

import dev.lbelin.forumapi.dto.AuthRequestDto;
import dev.lbelin.forumapi.dto.AuthResponseDto;

public interface AuthService {

    public AuthResponseDto login(AuthRequestDto authRequest);
}
