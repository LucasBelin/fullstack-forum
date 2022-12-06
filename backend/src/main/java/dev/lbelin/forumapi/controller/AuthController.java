package dev.lbelin.forumapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.lbelin.forumapi.dto.AuthRequestDto;
import dev.lbelin.forumapi.dto.AuthResponseDto;
import dev.lbelin.forumapi.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody final AuthRequestDto authRequest) {
        return ResponseEntity.ok(authService.login(authRequest));
    }
}
