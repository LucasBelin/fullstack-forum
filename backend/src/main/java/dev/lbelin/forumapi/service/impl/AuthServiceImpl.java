package dev.lbelin.forumapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import dev.lbelin.forumapi.dto.AuthRequestDto;
import dev.lbelin.forumapi.dto.AuthResponseDto;
import dev.lbelin.forumapi.security.JwtUtils;
import dev.lbelin.forumapi.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Value("${jwt.expiration.ms}")
    private Long expirationMs;

    @Override
    public AuthResponseDto login(AuthRequestDto authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                        authRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        return new AuthResponseDto(jwt, expirationMs);
    }
}
